package com.ecmdeveloper.graphqlserver.datafetcher;

import com.ecmdeveloper.graphqlserver.ContentEngineContext;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

public class FolderDataFetcher implements DataFetcher<Folder>{


	public FolderDataFetcher() {
	}
	
	@Override
	public Folder get(DataFetchingEnvironment environment) {
		
		ContentEngineContext context = environment.getContext();
		Folder folder = null;
		
		ObjectStore objectStore = context.getObjectStore("TARGET");			
		if ( environment.containsArgument("path") ) {
			try {
				folder = Factory.Folder.fetchInstance(objectStore, (String) environment.getArgument("path"), null);
			} catch (Exception e) {
				// TODO throw exception
				System.err.println(e.toString());
			}
		}

		return folder;
	}

}
