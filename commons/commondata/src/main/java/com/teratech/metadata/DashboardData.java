package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DashboardData implements Serializable {
    protected String id ;
    protected String name ;
    protected String label;
    protected List<AbstractDashboardSectionData> dashbordItems ;

    public DashboardData() {
        dashbordItems = new ArrayList<>();
    }

     /**
     *
     * @param id
     * @param name
     * @param title
     */
    public DashboardData(String id, String name, String title) {
        this.id = id;
        this.name = name;
        this.label = title;
        dashbordItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public DashboardData setName(String name) {
        this.name = name;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public DashboardData setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getId() {
        return id;
    }
    public DashboardData setId(String id) {
        this.id = id;
        return this;
    }

    public List<AbstractDashboardSectionData> getDashbordItems() {
        return dashbordItems;
    }

    public void setDashbordItems(List<AbstractDashboardSectionData> dashbordItems) {
        this.dashbordItems = dashbordItems;
    }
    public void addItem(AbstractDashboardSectionData item) {
        dashbordItems.add(item);
    }
}
