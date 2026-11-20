package com.teratech.model.settings;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;

import java.io.Serializable;

@MappedSuperclass
public  class UiThemSpec extends AbstractItem {
	//private static final long serialVersionUID = 1L;

    @Column(name = "erp_template")
    protected String erpTemplate;
    @Column(name = "theme_mode")
    protected String themeMode;
    @Column(name = "accent_color")
    protected String accentColor;
    @Column(name = "sidebar_style")
    protected String sidebarStyle;
    @Column(name = "sidebar_collapsed")
    protected Boolean sidebarCollapsed;
    @Column(name = "topbar_style")
    protected String topbarStyle;

    public UiThemSpec() {
    }

    public String getErpTemplate() {
        return erpTemplate;
    }

    public UiThemSpec setErpTemplate(String erpTemplate) {
        this.erpTemplate = erpTemplate;
        return this;
    }

    public String getThemeMode() {
        return themeMode;
    }

    public UiThemSpec setThemeMode(String themeMode) {
        this.themeMode = themeMode;
        return this;
    }

    public String getAccentColor() {
        return accentColor;
    }

    public UiThemSpec setAccentColor(String accentColor) {
        this.accentColor = accentColor;
        return this;
    }

    public String getSidebarStyle() {
        return sidebarStyle;
    }

    public UiThemSpec setSidebarStyle(String sidebarStyle) {
        this.sidebarStyle = sidebarStyle;
        return this;
    }

    public Boolean getSidebarCollapsed() {
        return sidebarCollapsed;
    }

    public UiThemSpec setSidebarCollapsed(Boolean sidebarCollapsed) {
        this.sidebarCollapsed = sidebarCollapsed;
        return this;
    }

    public String getTopbarStyle() {
        return topbarStyle;
    }

    public UiThemSpec setTopbarStyle(String topbarStyle) {
        this.topbarStyle = topbarStyle;
        return this;
    }

    @Override
    public Object getPk() {
        return null;
    }

    @Override
    public void toStringValue() {

    }
}
