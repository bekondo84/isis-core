package com.teratech.metadata;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.Objects;

public class AbstractDashboardSectionData implements Serializable {
    protected String name;
    protected String label;
    protected String icon;
    protected Integer position;
    protected Integer columns;
    protected Boolean header = false;
    protected String type;

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

    public String getType() {
        return type;
    }

    public AbstractDashboardSectionData setType(String type) {
        this.type = type;
        return this;
    }

    public String getIcon() {
        return icon;
    }
    public AbstractDashboardSectionData setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public boolean isValid() {
        return StringUtils.isNotBlank(name)  && Objects.nonNull(position) && Objects.nonNull(columns)  ;
    }
}
