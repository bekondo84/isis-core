package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShutCutData implements Serializable {
    protected String code;
    protected int  counter;
    protected String icon ;
    protected String label ;
    protected String viewMode;
    protected String type ;
    protected List<FilterData> filters ;

    public ShutCutData() {
        filters = new ArrayList<>();
    }

    public ShutCutData(String code, int counter, String icon) {
        this.code = code;
        this.counter = counter;
        this.icon = icon;
        filters = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public ShutCutData setCode(String code) {
        this.code = code;
        return this;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getIcon() {
        return icon;
    }

    public ShutCutData setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public ShutCutData setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getViewMode() {
        return viewMode;
    }

    public ShutCutData setViewMode(String viewMode) {
        this.viewMode = viewMode;
        return this;
    }

    public String getType() {
        return type;
    }

    public ShutCutData setType(String type) {
        this.type = type;
        return this;
    }

    public void addFilter(FilterData filter) {
        filters.add(filter);
    }
    public List<FilterData> getFilters() {
        return Collections.unmodifiableList(filters);
    }

    public void setFilters(List<FilterData> filters) {
        this.filters = filters;
    }
}
