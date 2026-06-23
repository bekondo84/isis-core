package com.teratech.metadata;

import java.io.Serializable;
import java.util.Objects;

public class SearchColumn implements Serializable {
    protected String fieldName;
    protected String label;
    protected String type;
    protected String value;
    protected String cond ;

    public SearchColumn() {
    }

    public SearchColumn(String fieldName, String label, String type) {
        this.fieldName = fieldName;
        this.label = label;
        this.type = type;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCond() {
        return cond;
    }

    public SearchColumn setCond(String cond) {
        this.cond = cond;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchColumn that = (SearchColumn) o;
        return Objects.equals(fieldName, that.fieldName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fieldName);
    }
}
