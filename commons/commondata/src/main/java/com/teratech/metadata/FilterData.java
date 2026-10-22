package com.teratech.metadata;

import java.io.Serializable;

public class FilterData implements Serializable {
    private String source;
    private String target;
    private String operator;
    private String nature;//two possible value : field or value
    private String type;

    public FilterData(String source, String value, String operator) {
        this.source = source;
        this.target = value;
        this.operator = operator;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
