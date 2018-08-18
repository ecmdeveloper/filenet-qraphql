package com.ecmdeveloper.graphqlserver.datafetcher;

import java.util.Optional;

import com.ecmdeveloper.graphqlserver.ContentEngineContext;
import com.filenet.api.core.IndependentObject;
import com.filenet.api.core.ObjectStore;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

public class IndependentObjectDataFetcher  implements DataFetcher<IndependentObject> {

	private final String className;

	public IndependentObjectDataFetcher(String className) {
		this.className = className;
	}
	
	@Override
	public IndependentObject get(DataFetchingEnvironment environment) {
		
		ContentEngineContext context = environment.getContext();
		ObjectStore objectStore = context.getObjectStore("TARGET");
		Optional<String> pathOrId = getPathOrId(environment);
		if ( pathOrId.isPresent()) {
			return objectStore.fetchObject(className, pathOrId.get(), null);
		}
		return null;
	}

	private Optional<String> getPathOrId(DataFetchingEnvironment environment) {
		String argument = environment.getArgument("path");
		if ( argument != null) {
			return Optional.of(argument);
		}

		argument = environment.getArgument("Id");
		if ( argument != null) {
			return Optional.of(argument);
		}
		return Optional.empty();
	}

}
