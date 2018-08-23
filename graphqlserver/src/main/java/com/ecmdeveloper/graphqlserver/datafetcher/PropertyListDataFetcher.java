/**
 * 
 */
package com.ecmdeveloper.graphqlserver.datafetcher;

import static com.ecmdeveloper.graphqlserver.utils.CEAPIStreams.asStream;

import java.util.stream.Collectors;

import com.filenet.api.core.EngineObject;
import com.filenet.api.property.Property;
import com.filenet.api.property.PropertyBooleanList;
import com.filenet.api.property.PropertyDateTimeList;
import com.filenet.api.property.PropertyFloat64List;
import com.filenet.api.property.PropertyIdList;
import com.filenet.api.property.PropertyInteger32List;
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
        } else if (property instanceof PropertyIdList ) {
        	return (T) asStream(property.getIdListValue()).map(Object::toString).collect(Collectors.toList());
        } else if (property instanceof PropertyBooleanList ) {
        	return (T) asStream(property.getBooleanListValue()).collect(Collectors.toList());
        } else if (property instanceof PropertyInteger32List ) {
        	return (T) asStream(property.getInteger32ListValue()).collect(Collectors.toList());
        } else if (property instanceof PropertyFloat64List ) {
        	return (T) asStream(property.getFloat64ListValue()).collect(Collectors.toList());
        } else if (property instanceof PropertyDateTimeList ) {
        	return (T) asStream(property.getDateTimeListValue()).collect(Collectors.toList());
        }
     
        return (T) source.getProperties().getObjectValue(propertyName);
	}
}
