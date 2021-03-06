/**
 * 
 */
package com.ecmdeveloper.graphqlserver.datafetcher;

import java.util.List;

import com.filenet.api.admin.PropertyDefinition;
import com.filenet.api.constants.Cardinality;
import com.filenet.api.constants.TypeID;

import graphql.schema.DataFetcher;

/**
 * @author Ricardo Belfor
 *
 */
public class PropertyDataFetcherFactory {

	public static DataFetcher<?> get(PropertyDefinition p) {
		
		switch (p.get_DataType().getValue() ) {
		case TypeID.DOUBLE_AS_INT:
			if (p.get_Cardinality().equals(Cardinality.SINGLE )) {
				return new PropertyDataFetcher<Double>(p.get_SymbolicName() );
			} else {
				return new PropertyListDataFetcher<List<Double>>(p.get_SymbolicName() );
			}
		case TypeID.LONG_AS_INT:
			if (p.get_Cardinality().equals(Cardinality.SINGLE )) {
				return new PropertyDataFetcher<Integer>(p.get_SymbolicName() );
			} else {
				return new PropertyListDataFetcher<List<Integer>>(p.get_SymbolicName() );
			}
		case TypeID.BOOLEAN_AS_INT:
			if (p.get_Cardinality().equals(Cardinality.SINGLE )) {
				return new PropertyDataFetcher<Boolean>(p.get_SymbolicName() );
			} else {
				return new PropertyListDataFetcher<List<Boolean>>(p.get_SymbolicName() );
			}
		case TypeID.STRING_AS_INT:
		case TypeID.GUID_AS_INT:
		default:
			if (p.get_Cardinality().equals(Cardinality.SINGLE )) {
				return new PropertyDataFetcher<String>(p.get_SymbolicName() );
			} else {
				return new PropertyListDataFetcher<List<String>>(p.get_SymbolicName() );
			}
		}
	}
}
