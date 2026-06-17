package com.teratech.metadata;

import java.io.Serializable;

public class SearchColumn extends MetaColumn implements Serializable {
    protected String cond ;
    /**
     * @param type
     * @param fieldName
     */
    public SearchColumn(String type, String fieldName, String cond) {
        super(type, fieldName);
        this.cond = cond ;
    }

    public SearchColumn(MetaColumn column) {
        super(column.type, column.fieldName);
        search = column.search;
        label = column.label;
        description = column.description;
        mandatory = column.mandatory;
        editable = column.editable;
        updatable = column.updatable;
        show = column.show;
        widget = column.widget ;
        unique = column.unique ;
        email = column.email ;
        max = column.max;
        min = column.min;
        pattern = column.pattern;
        meta = column.meta ;
        sequence = column.sequence ;
    }

    public String getCond() {
        return cond;
    }

    public SearchColumn setCond(String cond) {
        this.cond = cond;
        return this;
    }
}
