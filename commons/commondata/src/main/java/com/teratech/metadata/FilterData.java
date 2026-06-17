package com.teratech.metadata;

import java.io.Serializable;

public class FilterData implements Serializable {
    private String source;
    private String value;

    private String operator;

    public FilterData(String source, String value, String operator) {
        this.source = source;
        this.value = value;
        this.operator = operator;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
