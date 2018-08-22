/**
 * 
 */
package com.ecmdeveloper.graphqlserver.datafetcher;

import static com.ecmdeveloper.graphqlserver.utils.CEAPIStreams.asStream;

import java.util.stream.Collectors;

import com.filenet.api.core.EngineObject;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.property.Property;
import com.filenet.api.property.PropertyId;
import com.filenet.api.property.PropertyString;
import com.filenet.api.property.PropertyStringList;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

/**
 * @author Ricardo Belfor
 *
 */
public class PropertyListDataFetcher <T> implements DataFetcher<T> {

	private String propertyName;

	PropertyListDataFetcher(String propertyName) {
		this.propertyName = propertyName;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(DataFetchingEnvironment environment) {
		
		EngineObject source = environment.getSource();
        if (source == null) return null;

        Property property = source.getProperties().get(propertyName);
        
        if ( property instanceof PropertyStringList) {
        	return (T) asStream(property.getStringListValue()).collect(Collectors.toList());
        }
     
        return (T) source.getProperties().getObjectValue(propertyName);
	}

}
