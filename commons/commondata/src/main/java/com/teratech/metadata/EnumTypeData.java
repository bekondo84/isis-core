package com.teratech.metadata;

import java.io.Serializable;

public class EnumTypeData implements Serializable {
    protected  String code;
    protected String name;

    public EnumTypeData() {
    }

    public EnumTypeData(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
