/**
 * 
 */
package com.ecmdeveloper.graphqlserver.schema;

import static com.ecmdeveloper.graphqlserver.utils.CEAPIStreams.asStream;
import static graphql.Scalars.GraphQLBoolean;
import static graphql.Scalars.GraphQLString;
import static graphql.Scalars.GraphQLID;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;

import java.util.function.Consumer;

import com.ecmdeveloper.graphqlserver.datafetcher.PropertyDataFetcher;
import com.filenet.api.admin.ClassDefinition;
import com.filenet.api.admin.PropertyDefinition;
import com.filenet.api.admin.PropertyDefinitionBoolean;
import com.filenet.api.admin.PropertyDefinitionId;
import com.filenet.api.admin.PropertyDefinitionString;
import com.filenet.api.collection.PropertyDefinitionList;
import com.filenet.api.core.Factory;
import com.filenet.api.core.IndependentObject;
import com.filenet.api.core.ObjectStore;

import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType.Builder;

/**
 * @author Ricardo Belfor
 *
 */
public abstract class ContentEngineSchemaBuilder extends Builder {

	private ObjectStore objectStore;

	public ContentEngineSchemaBuilder(ObjectStore objectStore) {
		this.objectStore = objectStore;
		
   		field(newFieldDefinition()
   				.name("ClassName")
   				.type(GraphQLString)
   				.dataFetcher( env -> ((IndependentObject)env.getSource() ).getClassName() ) );

	}

	public ContentEngineSchemaBuilder withClass(String className) {
		
		name(className);
		SchemaClassDefinition classDefinition = new SchemaClassDefinition(objectStore);
		fields( classDefinition.getFieldDefinitions(className) );
		return this;
	}
}
