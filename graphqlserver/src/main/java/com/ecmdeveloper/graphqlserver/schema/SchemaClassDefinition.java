/**
 * 
 */
package com.ecmdeveloper.graphqlserver.schema;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.ecmdeveloper.graphqlserver.utils.CEAPIStreams.asStream;
import static graphql.Scalars.GraphQLBoolean;
import static graphql.Scalars.GraphQLID;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;

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

/**
 * @author Ricardo Belfor
 *
 */
public class SchemaClassDefinition {

	private final ObjectStore objectStore;

	public SchemaClassDefinition(ObjectStore objectStore) {
		this.objectStore = objectStore;
	}
	
	public List<GraphQLFieldDefinition> getFieldDefinitions(String className) {
		
		ClassDefinition classDefinition = Factory.ClassDefinition.fetchInstance(objectStore, className, null);
		PropertyDefinitionList propertyDefinitions = classDefinition.get_PropertyDefinitions();
		
		Function<? super PropertyDefinition, GraphQLFieldDefinition > action2 = p -> { 
			if ( p instanceof PropertyDefinitionString ||  p instanceof PropertyDefinitionId) {
				return getStringField(p);
			} else if (p instanceof PropertyDefinitionBoolean ) {
				return getBooleanField((PropertyDefinitionBoolean) p);
			}
			return null;
		};
		
		return asStream(propertyDefinitions).map(action2).filter(Objects::nonNull).collect(Collectors.toList());
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
