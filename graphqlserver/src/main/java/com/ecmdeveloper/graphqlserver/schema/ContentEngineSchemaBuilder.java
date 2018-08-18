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
	}
	
	public ContentEngineSchemaBuilder withClass(String className) {

		ClassDefinition classDefinition = Factory.ClassDefinition.fetchInstance(objectStore, className, null);
		
		PropertyDefinitionList propertyDefinitions = classDefinition.get_PropertyDefinitions();
		
		this.name(className);

		Consumer<? super PropertyDefinition> action = p -> { 
			if ( p instanceof PropertyDefinitionString ||  p instanceof PropertyDefinitionId) {
				this.field(getStringField(p));
			} else if (p instanceof PropertyDefinitionBoolean ) {
				this.field(getBooleanField((PropertyDefinitionBoolean) p));
			}
		};
		
		asStream(propertyDefinitions).forEach(action);
		
		return this;
	}

	private GraphQLFieldDefinition getStringField(PropertyDefinition propertyDefinition) {
		return newFieldDefinition()
        .name(propertyDefinition.get_SymbolicName() )
        .description(propertyDefinition.get_DisplayName())
        .type(propertyDefinition instanceof PropertyDefinitionId? GraphQLID :GraphQLString)
        .dataFetcher( new PropertyDataFetcher<String>(propertyDefinition.get_SymbolicName() )) 
        .build();
	}

	private GraphQLFieldDefinition getBooleanField(PropertyDefinitionBoolean propertyDefinition) {
		return newFieldDefinition()
        .name(propertyDefinition.get_SymbolicName() )
        .description(propertyDefinition.get_DisplayName())
        .type(GraphQLBoolean)
        .dataFetcher( new PropertyDataFetcher<Boolean>(propertyDefinition.get_SymbolicName() )) 
        .build();
	}
}
