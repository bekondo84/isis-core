package com.teratech.metadata;

import java.io.Serializable;

public class AbstractSection implements Serializable {
    protected String name;
    protected String title;
    protected int columns;
    protected  boolean header;

    public AbstractSection() {
    }

    public AbstractSection(String name, String title, int columns, boolean header) {
        this.name = name;
        this.title = title;
        this.columns = columns;
        this.header = header;
    }
}
