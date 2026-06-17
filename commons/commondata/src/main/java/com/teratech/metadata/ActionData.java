package com.teratech.metadata;

import java.io.Serializable;

public class ActionData implements Serializable {
    private String name ;
    private String code ;
    private Boolean redirect;
    private String type;
    private boolean modal;
    private String icon ;
    private Boolean dynamic ;
    private String position ;
    private String viewMode;
    protected String typeOp ;
    protected String badgeColor;
    protected String counter;


    public ActionData() {
        typeOp = "none";
    }

    public ActionData(String name, String code, String icon) {
        this.name = name;
        this.code = code;
        this.icon = icon;
        typeOp = "none";
    }

    public String getName() {
        return name;
    }

    public ActionData setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ActionData setCode(String code) {
        this.code = code;
        return this;
    }

    public Boolean getRedirect() {
        return redirect;
    }

    public ActionData setRedirect(Boolean redirect) {
        this.redirect = redirect;
        return this;
    }

    public Boolean getDynamic() {
        return dynamic;
    }

    public ActionData setDynamic(Boolean dynamic) {
        this.dynamic = dynamic;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public ActionData setPosition(String position) {
        this.position = position;
        return this;
    }

    public String getType() {
        return type;
    }

    public ActionData setType(String type) {
        this.type = type;
        return this;
    }

    public boolean isModal() {
        return modal;
    }

    public ActionData setModal(boolean modal) {
        this.modal = modal;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public ActionData setIcon(String icon) {
        this.icon = icon;
        return  this;
    }

    public String getViewMode() {
        return viewMode;
    }

    public ActionData setViewMode(String viewMode) {
        this.viewMode = viewMode;
        return this;
    }

    public String getTypeOp() {
        return typeOp;
    }

    public ActionData setTypeOp(String typeOp) {
        this.typeOp = typeOp;
        return this ;
    }

    public String getBadgeColor() {
        return badgeColor;
    }

    public ActionData setBadgeColor(String badgeColor) {
        this.badgeColor = badgeColor;
        return this;
    }

    public String getCounter() {
        return counter;
    }

    public ActionData setCounter(String counter) {
        this.counter = counter;
        return this;
    }
}
