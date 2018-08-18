/**
 * 
 */
package com.ecmdeveloper.graphqlserver.datafetcher;

import static com.ecmdeveloper.graphqlserver.utils.CEAPIStreams.asStream;

import java.util.List;
import java.util.stream.Collectors;

import com.filenet.api.core.Connection;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

/**
 * @author Ricardo Belfor
 *
 */
public class ObjectStoresDataFetcher implements DataFetcher<List<Object>>{

	private Domain domain;

	public ObjectStoresDataFetcher(Connection connection) {
        domain = Factory.Domain.fetchInstance(connection, null, null);
	}

	@Override
	public List<Object> get(DataFetchingEnvironment environment) {
		
		System.out.println(environment.getContext().toString());
		
		environment.getFields().forEach( f -> System.out.println(f.getSelectionSet() ) );
		
		graphql.servlet.GraphQLContext contect = environment.getContext();
		if ( contect.getSubject().isPresent() ) {
			System.out.println("Got Subject!");
		}
		
        return asStream(domain.get_ObjectStores()).collect(Collectors.toList());
	}
}
