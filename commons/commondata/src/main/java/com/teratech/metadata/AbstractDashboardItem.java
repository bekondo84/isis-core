package com.teratech.metadata;

import java.io.Serializable;
import java.util.Objects;

public class AbstractDashboardItem implements Serializable {
    protected  String id;
    protected String label;
    protected String color;
    protected String icon;

    public AbstractDashboardItem() {
    }

    public AbstractDashboardItem(String id, String label, String color, String icon) {
        this.id = id;
        this.label = label;
        this.color = color;
        this.icon = icon;
    }

    public AbstractDashboardItem(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public AbstractDashboardItem setId(String id) {
        this.id = id;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public AbstractDashboardItem setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getColor() {
        return color;
    }

    public AbstractDashboardItem setColor(String color) {
        this.color = color;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public AbstractDashboardItem setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbstractDashboardItem that = (AbstractDashboardItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
