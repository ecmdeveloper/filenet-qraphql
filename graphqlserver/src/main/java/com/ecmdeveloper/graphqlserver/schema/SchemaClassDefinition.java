/**
 * 
 */
package com.ecmdeveloper.graphqlserver.schema;

import static com.ecmdeveloper.graphqlserver.utils.CEAPIStreams.asStream;
import static graphql.Scalars.GraphQLBoolean;
import static graphql.Scalars.GraphQLID;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.ecmdeveloper.graphqlserver.datafetcher.PropertyDataFetcherFactory;
import com.filenet.api.admin.ClassDefinition;
import com.filenet.api.admin.PropertyDefinition;
import com.filenet.api.collection.PropertyDefinitionList;
import com.filenet.api.constants.Cardinality;
import com.filenet.api.constants.TypeID;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;

import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLOutputType;

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
		
		Function<? super PropertyDefinition, GraphQLFieldDefinition > action = propertyDefinition -> {

			GraphQLOutputType outputType = getOutputType(propertyDefinition);
			if ( outputType != null) {
				return newFieldDefinition()
				        .name(propertyDefinition.get_SymbolicName() )
				        .description(propertyDefinition.get_DisplayName())
				        .type(outputType)
				        .dataFetcher( PropertyDataFetcherFactory.get(propertyDefinition) ) 
				        .build();
			}
			return null;
		};
		
		return asStream(propertyDefinitions).map(action).filter(Objects::nonNull).collect(Collectors.toList());
	}

	private GraphQLOutputType getOutputType(PropertyDefinition propertyDefinition) {
		
		GraphQLOutputType outputType = null;
		switch (propertyDefinition.get_DataType().getValue() ) {
		case TypeID.STRING_AS_INT:
			outputType = GraphQLString;
			break;
		case TypeID.GUID_AS_INT:
			outputType = GraphQLID;
			break;
		case TypeID.BOOLEAN_AS_INT:
			outputType = GraphQLBoolean;
			break;
		}
		
		if (outputType != null ) {
			if ( propertyDefinition.get_Cardinality().equals(Cardinality.SINGLE ) ) {
				return outputType;
			} else {
				return GraphQLList.list(outputType); 
			}
		}
		return null;
	}
}
