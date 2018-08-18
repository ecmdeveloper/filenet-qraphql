/**
 * 
 */
package com.ecmdeveloper.graphqlserver;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;
import static com.ecmdeveloper.graphqlserver.utils.CEAPIStreams.asStream;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.security.auth.Subject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecmdeveloper.graphqlserver.datafetcher.PropertyDataFetcher;
import com.ecmdeveloper.graphqlserver.schema.ContainerSchemaBuilder;
import com.ecmdeveloper.graphqlserver.schema.ContentEngineSchemaBuilder;
import com.ecmdeveloper.graphqlserver.schema.ContentSchemaBuilder;
import com.ecmdeveloper.graphqlserver.datafetcher.FolderDataFetcher;
import com.ecmdeveloper.graphqlserver.datafetcher.ObjectStoresDataFetcher;
import com.filenet.api.core.Connection;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.util.UserContext;

import graphql.schema.DataFetcher;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition.Builder;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLNonNull;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.GraphQLTypeReference;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.servlet.GraphQLContext;
import graphql.servlet.SimpleGraphQLServlet;

/**
 * @author Ricardo Belfor
 *
 */
@WebServlet(urlPatterns = "/graphqlce")
public class ContentEngineEndpoint extends SimpleGraphQLServlet {

	private static String url = "http://192.168.111.81:9080/wsi/FNCEWS40MTOM/";
	private static String userName = "p8admin";
	private static String password = "WelkoM01";
	private static Connection connection;
	
	private static final long serialVersionUID = -2339152187358224158L;

	public ContentEngineEndpoint() {
		super(buildDynamicSchema());
		addListener(ContentEngineSessionManager.getListener());
	}

    private static GraphQLSchema buildSchema() {

    	
    	DataFetcher<List<String>> ObjectStoreDataFetcher = new StaticDataFetcher(Arrays.asList("Hi!", "Hello!") );
    	DataFetcher<String> helloDataFetcher = new StaticDataFetcher("Hi!");
    	
		SchemaParser schemaParser = new SchemaParser();
		SchemaGenerator schemaGenerator = new SchemaGenerator();

		File schemaFile = new File("/Users/ricardobelfor/Documents/workspace-jee-luna-dojo/graphqlserver/src/main/resources/base-ce-schema.graphqls");

		TypeDefinitionRegistry typeRegistry = schemaParser.parse(schemaFile);
		RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring()
		    	.type("QueryType", typeWiring -> typeWiring.dataFetcher("objectStores", new ObjectStoresDataFetcher(connection) ))
		    	.type("ObjectStore", typeWiring -> typeWiring.dataFetcher("name", new PropertyDataFetcher<String>("name")))
		    	.build();

		return schemaGenerator.makeExecutableSchema(typeRegistry, wiring);
    }
    
   private static GraphQLSchema buildDynamicSchema() {
	   
       UserContext.get().pushSubject(getBootstrapSubject());
       try {

		   System.err.println( "Generating schema...");
		   
	       Domain domain = Factory.Domain.fetchInstance(connection, null, null);
		   ObjectStore objectStore = Factory.ObjectStore.fetchInstance(domain, "TARGET", null);

		   	GraphQLObjectType documentType = ContentSchemaBuilder.newObject(objectStore).withClass("Document").build();
			GraphQLObjectType folderType = ContainerSchemaBuilder.newObject(objectStore).withClass("Folder")
					.build();

			GraphQLArgument pathArgument = newArgument()
				      .name("path")
				      .type(new GraphQLNonNull(GraphQLString))
				      .build();
			
			GraphQLObjectType queryType = newObject()
	                .name("query")
	                .field( newFieldDefinition().name("folder").type(folderType).argument(pathArgument)
	                          .dataFetcher( new FolderDataFetcher() )
	                	      )
	                .field(newFieldDefinition().name("document").type(documentType).argument(pathArgument))
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
			
			return GraphQLSchema.newSchema()
	        .query(queryType)
	        .mutation(mutationType)
	        .build();
       } finally {
    	   UserContext.get().popSubject();
       }
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
