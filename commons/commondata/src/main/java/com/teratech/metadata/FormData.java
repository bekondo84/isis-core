package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        sections.sort(new Comparator<SectionData>() {
            @Override
            public int compare(SectionData o1, SectionData o2) {
                return Integer.compare(o1.getPosition(), o2.getPosition());
            }
        });
        return Collections.unmodifiableList(sections);
    }

    public void setSections(List<SectionData> sections) {
        this.sections = sections;
    }


}
