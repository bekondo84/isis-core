package com.teratech.metadata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

public class ActionData implements Serializable {
    private String name ;
    private String code ;
    private String type;
    private String icon ;
    private String position ;
    private String opeation ;
    private String color;
    private String action;
    private boolean askconfirmation;



    public ActionData() {


    }

    public ActionData(String name, String code, String icon) {
        this.name = name;
        this.code = code;
        this.icon = icon;
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

    public String getIcon() {
        return icon;
    }

    public ActionData setIcon(String icon) {
        this.icon = icon;
        return  this;
    }

    public String getOpeation() {
        return opeation;
    }

    public void setOpeation(String opeation) {
        this.opeation = opeation;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isAskconfirmation() {
        return askconfirmation;
    }

    public void setAskconfirmation(boolean askconfirmation) {
        this.askconfirmation = askconfirmation;
    }

    @JsonIgnore
    public boolean isValidate() {
       return StringUtils.isNotBlank(code)
               && StringUtils.isNotBlank(action)
               && StringUtils.isNotBlank(type)
               && StringUtils.isNotBlank(opeation)
               && StringUtils.isNotBlank(position);
    }
}
