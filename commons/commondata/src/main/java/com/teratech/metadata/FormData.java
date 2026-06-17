package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FormData implements Serializable {
    private List<SectionData> sections ;

    public FormData() {
        this.sections = new ArrayList<>();
    }

    public void addSection(final SectionData section) {
        this.sections.add(0, section);
    }
    public List<SectionData> getSections() {
        return Collections.unmodifiableList(sections);
    }

    public void setSections(List<SectionData> sections) {
        this.sections = sections;
    }


}
