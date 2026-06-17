package com.teratech.metadata;

import java.io.Serializable;

public class ShutCutData implements Serializable {
    protected String name;
    protected String code;
    protected String counter;
    protected String icon ;
    protected String label ;
    protected String viewMode;
    protected String type ;

    public ShutCutData() {
    }

    public ShutCutData(String name, String code, String counter, String icon) {
        this.name = name;
        this.code = code;
        this.counter = counter;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public ShutCutData setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ShutCutData setCode(String code) {
        this.code = code;
        return this;
    }

    public String getCounter() {
        return counter;
    }

    public ShutCutData setCounter(String counter) {
        this.counter = counter;
        return this ;
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
}
