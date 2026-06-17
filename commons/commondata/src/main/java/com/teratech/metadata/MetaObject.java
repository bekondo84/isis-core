package com.teratech.metadata;

import java.io.Serializable;

public class MetaObject<MetaData> extends MetaColumn implements Serializable {

    private MetaData metaData;

    /**
     *
     * @param type
     * @param fieldName
     */
    public MetaObject(String type, String fieldName) {
        super(type, fieldName);
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }
}
