package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SectionData extends AbstractSection implements Serializable {
    private List<MetaColumn> fields ;
    private List<SectionData> sections;
    private List<ShutCutData> shutcuts ;

    public SectionData() {
        this.fields = new ArrayList<>();
        this.sections = new ArrayList<>();
        this.shutcuts = new ArrayList<>();
        header = false;
    }

    public SectionData(String name, String title, int columns, boolean header) {
        this.name = name;
        this.title = title;
        this.columns = columns;
        this.fields = new ArrayList<>();
        this.sections = new ArrayList<>();
        this.shutcuts = new ArrayList<>();
        this.header = header;
    }
    public SectionData(String name, String title, int columns) {
        this.name = name;
        this.title = title;
        this.columns = columns;
        this.fields = new ArrayList<>();
        this.sections = new ArrayList<>();
        this.shutcuts = new ArrayList<>();
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

    public List<MetaColumn> getFields() {
        return fields;
    }

    public void setFields(List<MetaColumn> fields) {
        this.fields = fields;
    }

    public  void addField(final MetaColumn field) {
        fields.add(field);
    }

    public boolean isHeader() {
        return header;
    }

    public void setHeader(boolean header) {
        this.header = header;
    }

    public List<SectionData> getSections() {
        return Collections.unmodifiableList(sections);
    }

    public void setSections(List<SectionData> sections) {
        this.sections = sections;
    }

    public void  addSection(SectionData section) {
        sections.add(section);
    }

    public List<ShutCutData> getShutcuts() {
        return Collections.unmodifiableList(shutcuts);
    }

    public void addShutCut(final ShutCutData item) {
        shutcuts.add(item);
    }
}
