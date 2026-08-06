package com.teratech.metadata;

import java.io.Serializable;

public class AbstractSection implements Serializable {
    protected String name;
    protected String title;
    protected int columns;
    protected  boolean header;
    protected int position;

    public AbstractSection() {
    }

    public AbstractSection(String name, String title, int columns, int position, boolean header) {
        this.name = name;
        this.title = title;
        this.columns = columns;
        this.header = header;
        this.position = position;
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

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public boolean isHeader() {
        return header;
    }

    public void setHeader(boolean header) {
        this.header = header;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
