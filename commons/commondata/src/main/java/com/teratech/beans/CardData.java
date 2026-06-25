package com.teratech.beans;

import java.io.Serializable;

public class CardData implements Serializable {
    protected String color;
    protected Object value;
    protected String label;
    protected String icon ;

    public CardData() {
        color = "#6c757d" ;
    }

    public String getColor() {
        return color;
    }

    public CardData setColor(String color) {
        this.color = color;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public CardData setValue(Object value) {
        this.value = value;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public CardData setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public CardData setIcon(String icon) {
        this.icon = icon;
        return this;
    }
}
