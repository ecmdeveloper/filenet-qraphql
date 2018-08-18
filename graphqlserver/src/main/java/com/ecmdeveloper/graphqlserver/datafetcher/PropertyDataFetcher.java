/**
 * 
 */
package com.ecmdeveloper.graphqlserver.datafetcher;

import com.filenet.api.core.EngineObject;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.property.Property;
import com.filenet.api.property.PropertyString;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

/**
 * @author Ricardo Belfor
 *
 */
public class PropertyDataFetcher <T> implements DataFetcher<T> {

	private String propertyName;

	public PropertyDataFetcher(String propertyName) {
		this.propertyName = propertyName;
	}

	@Override
	public T get(DataFetchingEnvironment environment) {
		
		EngineObject source = environment.getSource();
        if (source == null) return null;

        Property property = source.getProperties().get(propertyName);
        if ( property instanceof PropertyString) {
        	return (T) property.getStringValue(); 
        }
        return (T) source.getProperties().getObjectValue(propertyName);
	}

}
