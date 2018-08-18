/**
 * 
 */
package com.ecmdeveloper.graphqlserver.schema;

import static com.ecmdeveloper.graphqlserver.utils.CEAPIStreams.asStream;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;

import java.util.stream.Collectors;

import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;

import graphql.schema.GraphQLList;
import graphql.schema.GraphQLTypeReference;

/**
 * @author Ricardo Belfor
 *
 */
public class ContainerSchemaBuilder extends ContentEngineSchemaBuilder {

    public static ContentEngineSchemaBuilder newObject(ObjectStore objectStore) {
        return new ContainerSchemaBuilder(objectStore);
    }	
 	
	public ContainerSchemaBuilder(ObjectStore objectStore) {
		super(objectStore);

		field( newFieldDefinition()
				.name("subFolders")
				.type(GraphQLList.list(new GraphQLTypeReference("Folder")))
				.dataFetcher( context -> asStream(((Folder)context.getSource()).get_SubFolders() ).collect(Collectors.toList())));

		field( newFieldDefinition()
				.name("containedDocuments")
				.type(GraphQLList.list(new GraphQLTypeReference("Document")))
				.dataFetcher(  context -> asStream(((Folder)context.getSource()).get_ContainedDocuments() ).collect(Collectors.toList())));
	}
}
