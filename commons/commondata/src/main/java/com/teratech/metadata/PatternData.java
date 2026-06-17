package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatternData implements Serializable {
    private String separator;

    private List<String> fields;

    public PatternData() {
        fields = new ArrayList<>();
    }

    public PatternData(String separator, String... fields) {
        this.separator = separator;
        this.fields = Arrays.asList(fields);
    }

    public PatternData(String separator, List<String> fields) {
        this.separator = separator;
        this.fields = fields;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }
}
