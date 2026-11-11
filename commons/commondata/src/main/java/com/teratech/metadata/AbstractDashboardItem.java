package com.teratech.metadata;

import java.io.Serializable;

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

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
