package com.teratech.metadata;

import java.io.Serializable;

/**
 *
 */
public class MetaArray extends MetaColumn implements Serializable {

     private MetaData metaData;

    /**
     *
     * @param type
     * @param fieldName
     */
    public MetaArray(String type, String fieldName) {
        super(type, fieldName);
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }
}
