/**
 * 
 */
package com.ecmdeveloper.graphqlserver.schema;

import com.filenet.api.core.ObjectStore;

/**
 * @author Ricardo Belfor
 *
 */
public class ContentSchemaBuilder extends ContentEngineSchemaBuilder {

    public static ContentEngineSchemaBuilder newObject(ObjectStore objectStore) {
        return new ContentSchemaBuilder(objectStore);
    }	

    public ContentSchemaBuilder(ObjectStore objectStore) {
		super(objectStore);
	}
}
