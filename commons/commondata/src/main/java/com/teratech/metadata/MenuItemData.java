package com.teratech.metadata;

import java.io.Serializable;

public class MenuItemData extends AbstractMenuData implements Serializable {
    private String action;

    private String type;

    private String viewMode;

    private Boolean modal;

    private String template;

    private String counter;

    private String badgeColor;

    public MenuItemData() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getViewMode() {
        return viewMode;
    }

    public void setViewMode(String viewMode) {
        this.viewMode = viewMode;
    }

    public Boolean getModal() {
        return modal;
    }

    public void setModal(Boolean modal) {
        this.modal = modal;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public String getBadgeColor() {
        return badgeColor;
    }

    public void setBadgeColor(String badgeColor) {
        this.badgeColor = badgeColor;
    }

    @Override
    public String toString() {
        return "NavigationLinkData{" +
                ", code='" + code + '\'' +
                ", action='" + action + '\'' +
                ", type='" + type + '\'' +
                ", viewMode='" + viewMode + '\'' +
                ", modal=" + modal +
                ", template='" + template + '\'' +
                '}';
    }
}
