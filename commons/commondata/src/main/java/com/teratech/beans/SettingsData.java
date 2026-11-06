package com.teratech.beans;

import com.teratech.metadata.MetaColumn;

import java.io.Serializable;
import java.util.List;

public class SettingsData implements Serializable {
    private static final long serialVersionUID = 1L;

    private String typeCode;
    private String type;
    private List<MetaColumn> columns;

    public SettingsData() {
    }

    public SettingsData(String typeCode, String type) {
        this.typeCode = typeCode;
        this.type = type;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<MetaColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<MetaColumn> columns) {
        this.columns = columns;
    }
}
