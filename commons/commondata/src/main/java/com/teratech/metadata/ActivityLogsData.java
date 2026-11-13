package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivityLogsData extends ChartItemData{

    protected List<DataSet> activities ;

    public ActivityLogsData() {
        this.type = "activitylogs";
        activities = new ArrayList<DataSet>();
    }

    public ActivityLogsData(String id, String name) {
        super(id, name);
        this.type = "activitylogs";
        activities = new ArrayList<DataSet>();
    }

    public ActivityLogsData(String id, String label, String action, String method, Integer refresh) {
        super(id, label, action, method, refresh);
        this.type = "activitylogs";
        activities = new ArrayList<DataSet>();
    }

    public List<DataSet> getActivities() {
        return Collections.unmodifiableList(activities);
    }

    public void setActivities(List<DataSet> activities) {
        this.activities = activities;
    }

    public void addActivity(DataSet activity){
        activities.add(activity);
    }

    public static class DataSet implements Serializable {
        private String icon;
        private String color;
        private String activity;
        private Integer since;
        private String timeunit;

        public DataSet() {
        }
        public DataSet(String icon, String color, String actvity, Integer since, String timeunit) {
            this.icon = icon;
            this.color = color;
            this.activity = actvity;
            this.since = since;
            this.timeunit = timeunit;
        }

        public String getIcon() {
            return icon;
        }

        public DataSet setIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public String getColor() {
            return color;
        }

        public DataSet setColor(String color) {
            this.color = color;
            return this;
        }

        public String getActvity() {
            return activity;
        }

        public DataSet setActvity(String actvity) {
            this.activity = actvity;
            return this;
        }

        public Integer getSince() {
            return since;
        }

        public DataSet setSince(Integer since) {
            this.since = since;
            return this;
        }

        public String getTimeunit() {
            return timeunit;
        }

        public DataSet setTimeunit(String timeunit) {
            this.timeunit = timeunit;
            return this;
        }
    }
}
