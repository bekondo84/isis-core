package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DashboardMeta implements Serializable {
    protected String name ;
    protected String title;
    protected List<SectionData> sections ;

    public DashboardMeta() {
        sections = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SectionData> getSections() {
        return Collections.unmodifiableList(sections);
    }

    public void setSections(List<SectionData> sections) {
        this.sections = sections;
    }

    public void addSection(final SectionData section) {
        this.sections.add(section);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
