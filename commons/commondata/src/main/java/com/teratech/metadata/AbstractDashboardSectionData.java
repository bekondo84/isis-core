package com.teratech.metadata;

import java.io.Serializable;

public class AbstractDashboardSectionData implements Serializable {
    protected String name;
    protected String label;
    protected Integer position;
    protected Integer columns;
    protected Boolean header = false;

    public AbstractDashboardSectionData() {
    }

    /**
     *
     * @param name
     * @param label
     * @param position
     * @param columns
     * @param header
     */
    public AbstractDashboardSectionData(String name, String label, Integer position, Integer columns, Boolean header) {
        this.name = name;
        this.label = label;
        this.position = position;
        this.columns = columns;
        this.header = header;
    }

    public String getName() {
        return name;
    }

    public AbstractDashboardSectionData setName(String name) {
        this.name = name;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public AbstractDashboardSectionData setLabel(String label) {
        this.label = label;
        return this;
    }

    public Integer getPosition() {
        return position;
    }

    public AbstractDashboardSectionData setPosition(Integer position) {
        this.position = position;
        return this;
    }

    public Integer getColumns() {
        return columns;
    }

    public AbstractDashboardSectionData setColumns(Integer columns) {
        this.columns = columns;
        return this;
    }

    public Boolean getHeader() {
        return header;
    }

    public AbstractDashboardSectionData setHeader(Boolean header) {
        this.header = header;
        return this;
    }

    public boolean isValid() {
        return name != null && position != null && columns != null ;
    }
}
