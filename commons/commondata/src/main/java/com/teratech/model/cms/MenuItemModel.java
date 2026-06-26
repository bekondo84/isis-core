package com.teratech.model.cms;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("ITEM")
public class MenuItemModel extends AbstractMenu {

    @Column(name = "act_name")
    private String action;
    private String type;
    @Column(name = "view_type")
    private String viewType;
    private String template;
    @Column(name = "badge_color")
    private String badgeColor;
    private boolean modal ;

    public MenuItemModel(String code) {
        super(code);
    }

    public MenuItemModel() {
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

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getBadgeColor() {
        return badgeColor;
    }

    public void setBadgeColor(String badgeColor) {
        this.badgeColor = badgeColor;
    }

    public boolean isModal() {
        return modal;
    }

    public void setModal(boolean modal) {
        this.modal = modal;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
