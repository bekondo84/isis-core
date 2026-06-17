package com.teratech.metadata;

import java.io.Serializable;

public class TabData implements Serializable {
    private String name ;
    private String title ;
    private FormData form ;

    public TabData() {
    }

    public TabData(String name, String title) {
        this.name = name;
        this.title = title;
        form =new FormData();
    }

    public TabData(String name, String title, FormData form) {
        this.name = name;
        this.title = title;
        this.form = form;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FormData getForm() {
        return form;
    }

    public void setForm(FormData form) {
        this.form = form;
    }
}
