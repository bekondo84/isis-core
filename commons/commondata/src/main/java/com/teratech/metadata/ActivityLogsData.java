package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivityLogsData extends ChartItemData{

    protected List<ActivityLogData> activities ;

    public ActivityLogsData() {
        this.type = "activitylogs";
        activities = new ArrayList<ActivityLogData>();
    }

    public ActivityLogsData(String id, String name) {
        super(id, name);
        this.type = "activitylogs";
        activities = new ArrayList<ActivityLogData>();
    }

    public ActivityLogsData(String id, String label, String action, String method, Integer refresh) {
        super(id, label, action, method, refresh);
        this.type = "activitylogs";
        activities = new ArrayList<ActivityLogData>();
    }

    public List<ActivityLogData> getActivities() {
        return Collections.unmodifiableList(activities);
    }

    public void setActivities(List<ActivityLogData> activities) {
        this.activities = activities;
    }

    public void addActivity(ActivityLogData activity){
        activities.add(activity);
    }

    public static class ActivityLogData implements Serializable {
        private String icon;
        private String color;
        private String actvity;
        private Integer since;
        private String timeunit;

        public ActivityLogData() {
        }
        public ActivityLogData(String icon, String color, String actvity, Integer since, String timeunit) {
            this.icon = icon;
            this.color = color;
            this.actvity = actvity;
            this.since = since;
            this.timeunit = timeunit;
        }

        public String getIcon() {
            return icon;
        }

        public ActivityLogData setIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public String getColor() {
            return color;
        }

        public ActivityLogData setColor(String color) {
            this.color = color;
            return this;
        }

        public String getActvity() {
            return actvity;
        }

        public ActivityLogData setActvity(String actvity) {
            this.actvity = actvity;
            return this;
        }

        public Integer getSince() {
            return since;
        }

        public ActivityLogData setSince(Integer since) {
            this.since = since;
            return this;
        }

        public String getTimeunit() {
            return timeunit;
        }

        public ActivityLogData setTimeunit(String timeunit) {
            this.timeunit = timeunit;
            return this;
        }
    }
}
