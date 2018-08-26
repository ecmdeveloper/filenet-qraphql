/**
 * 
 */
package com.ecmdeveloper.graphqlserver;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLInterfaceType.newInterface;
import static graphql.schema.GraphQLObjectType.newObject;

import java.util.Optional;

import javax.security.auth.Subject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecmdeveloper.graphqlserver.datafetcher.IndependentObjectDataFetcher;
import com.ecmdeveloper.graphqlserver.schema.ContainerSchemaBuilder;
import com.ecmdeveloper.graphqlserver.schema.ContentSchemaBuilder;
import com.ecmdeveloper.graphqlserver.schema.SchemaClassDefinition;
import com.filenet.api.core.Connection;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;
import com.filenet.api.core.IndependentObject;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.util.UserContext;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition.Builder;
import graphql.schema.GraphQLInterfaceType;
import graphql.schema.GraphQLNonNull;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLContext;
import graphql.servlet.SimpleGraphQLServlet;

/**
 * @author Ricardo Belfor
 *
 */
@WebServlet(urlPatterns = "/graphqlce")
public class ContentEngineEndpoint extends SimpleGraphQLServlet {

	private static final String OBJECT_STORE_NAME = "OS";
	public static String url = "iiop://localhost:2809/FileNet/Engine"; //"http://192.168.111.82:9080/wsi/FNCEWS40MTOM/";
	private static String userName = "p8admin";
	private static String password = "Welkom01";
	private static Connection connection;
	
	private static final long serialVersionUID = -2339152187358224158L;

	public ContentEngineEndpoint() {
		super(buildDynamicSchema());
		addListener(ContentEngineSessionManager.getListener());
	}
    
   private static GraphQLSchema buildDynamicSchema() {
	   
       UserContext.get().pushSubject(getBootstrapSubject());
       try {

		   System.out.println( "Generating schema...");
		   
	       Domain domain = Factory.Domain.fetchInstance(connection, null, null);
		   ObjectStore objectStore = Factory.ObjectStore.fetchInstance(domain, OBJECT_STORE_NAME, null);

		   SchemaClassDefinition classDefinition = new SchemaClassDefinition(objectStore);
		   
		   GraphQLInterfaceType contentInterface = newInterface()
		   		.name("Content")
		   		.fields( classDefinition.getFieldDefinitions("Document") )
		   		.field(newFieldDefinition().name("ClassName").type(GraphQLString) )
		   		.description("Acts as an abstract wrapper around all document classes")
		   		.typeResolver( env -> {
		   			String className = ((IndependentObject)env.getObject() ).getClassName();
		   			GraphQLObjectType type = (GraphQLObjectType) env.getSchema().getType(className);
		   			if ( type != null) {
		   				System.out.println("Resolving to '" + type.getName() + "'");
		   				return type;
		   			}
					return (GraphQLObjectType) env.getSchema().getType("Document");
					
		   		} ).build();
		   
		   	GraphQLObjectType documentType = ContentSchemaBuilder
		   			.newObject(objectStore)
		   			.withClass("Document")
		   			.withInterface(contentInterface).build();

		   	GraphQLObjectType emailType = ContentSchemaBuilder
		   			.newObject(objectStore)
		   			.withClass("Email")
		   			.withInterface(contentInterface).build();
		   	
			GraphQLObjectType folderType = ContainerSchemaBuilder.newObject(objectStore).withClass("Folder").name("Folder").build();

			GraphQLArgument pathArgument = newArgument()
				      .name("path")
				      .type(GraphQLString)
				      .build();

			GraphQLArgument idArgument = newArgument()
				      .name("Id")
				      .type( Scalars.GraphQLID )
				      .build();
			
			GraphQLObjectType queryType = newObject()
	                .name("query")
	                .field( newFieldDefinition()
	                		.name("folder")
	                		.type(folderType)
	                		.argument(pathArgument)
	                		.argument(idArgument)
	                        .dataFetcher( new IndependentObjectDataFetcher(OBJECT_STORE_NAME, "Folder") )
	                	      )
	                .field(getDocumentTypeAsField(documentType, idArgument) )
	                .field(getDocumentTypeAsField(emailType, idArgument) )
	                .description("The object store object")
	                .build();	   
	
			GraphQLArgument username = newArgument().name("username").type(new GraphQLNonNull(GraphQLString) ).build();
			GraphQLArgument password = newArgument().name("password").type(new GraphQLNonNull(GraphQLString) ).build();
			
			Builder logonBuilder = newFieldDefinition()
					.name("logon")
					.type(folderType)
					.argument(username)
					.argument(password)
			        .type(GraphQLString)
			        .dataFetcher( ContentEngineSessionManager.getLogonMutation() );
			
			GraphQLObjectType mutationType = newObject()
	                .name("mutation")
	                .field( logonBuilder)
	                .description("The object store object")
	                .build();	   		
			System.err.println( "Generating schema done...");
			
			return GraphQLSchema.newSchema().query(queryType).mutation(mutationType).build();
			
       } finally {
    	   UserContext.get().popSubject();
       }
   	}

	private static Builder getDocumentTypeAsField(GraphQLObjectType documentType, GraphQLArgument idArgument) {
		return newFieldDefinition()
				.name(documentType.getName() )
				.type(documentType)
				.argument(idArgument)
				.dataFetcher( new IndependentObjectDataFetcher(OBJECT_STORE_NAME, documentType.getName()) );
	}

	protected static Subject getBootstrapSubject() {
    	
	   connection = Factory.Connection.getConnection(url);
       return UserContext.createSubject(connection, userName, password, null );
    }

	@Override
	protected GraphQLContext createContext(Optional<HttpServletRequest> request, Optional<HttpServletResponse> response) {
		return new ContentEngineContext(request, response);
	}      
}
