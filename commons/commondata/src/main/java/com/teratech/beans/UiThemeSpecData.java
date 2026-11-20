package com.teratech.beans;

import java.io.Serializable;

public class UiThemeSpecData implements Serializable {
    protected String name;
    protected String slogan;
    protected String erpTemplate;
    protected String themeMode;
    protected String accentColor;
    protected String sidebarStyle;
    protected Boolean sidebarCollapsed;
    protected String topbarStyle;

    public UiThemeSpecData()
    {

    }

    public String getErpTemplate() {
        return erpTemplate;
    }

    public UiThemeSpecData setErpTemplate(String erpTemplate) {
        this.erpTemplate = erpTemplate;
        return this;
    }

    public String getThemeMode() {
        return themeMode;
    }

    public UiThemeSpecData setThemeMode(String themeMode) {
        this.themeMode = themeMode;
        return this;
    }

    public String getAccentColor() {
        return accentColor;
    }

    public UiThemeSpecData setAccentColor(String accentColor) {
        this.accentColor = accentColor;
        return this;
    }

    public String getSidebarStyle() {
        return sidebarStyle;
    }

    public UiThemeSpecData setSidebarStyle(String sidebarStyle) {
        this.sidebarStyle = sidebarStyle;
        return this;
    }

    public Boolean getSidebarCollapsed() {
        return sidebarCollapsed;
    }

    public UiThemeSpecData setSidebarCollapsed(Boolean sidebarCollapsed) {
        this.sidebarCollapsed = sidebarCollapsed;
        return this;
    }

    public String getTopbarStyle() {
        return topbarStyle;
    }

    public UiThemeSpecData setTopbarStyle(String topbarStyle) {
        this.topbarStyle = topbarStyle;
        return this;
    }

    public String getName() {
        return name;
    }

    public UiThemeSpecData setName(String name) {
        this.name = name;
        return this;
    }

    public String getSlogan() {
        return slogan;
    }

    public UiThemeSpecData setSlogan(String slogan) {
        this.slogan = slogan;
        return this;
    }
}
