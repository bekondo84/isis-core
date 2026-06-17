package com.teratech.metadata;


import java.io.Serializable;

public class NavigationComponentData implements Serializable {
    protected String code;

    protected Boolean activate;

    protected String icon;

    protected String label;

    protected Short position;

    //protected NavigationNodeLevel level;

    protected boolean selected = false;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getActivate() {
        return activate;
    }

    public void setActivate(Boolean activate) {
        this.activate = activate;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Short getPosition() {
        return position;
    }

    public void setPosition(Short position) {
        this.position = position;
    }
}
