package com.teratech.metadata;

import java.io.Serializable;

public class WorkflowKpiCardResume implements Serializable {
    protected  String label;
    protected String icon;
    protected String color;
    protected String message;

    public WorkflowKpiCardResume() {

    }
    public WorkflowKpiCardResume(String label, String icon, String color, String message) {
        this.icon = icon;
        this.label = label;
        this.color = color;
        this.message = message;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
