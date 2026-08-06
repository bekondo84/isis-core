package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DashbordSectionData extends AbstractSection implements Serializable {
    protected List<DashbordSectionData> sections ;


    public DashbordSectionData() {
        sections = new ArrayList<>();
    }

    public DashbordSectionData(String name, String title, int columns, int position, boolean header) {
        super(name, title, columns,position, header);
        sections = new ArrayList<>();
    }
}
