package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoughnutChartData extends ChartItemData{

    protected List<DataSet> data;

    public DoughnutChartData() {
        data = new ArrayList<DataSet>();
        type = "doughnut";
    }

    public DoughnutChartData(String id, String name) {
        super(id, name);
        data = new ArrayList<DataSet>();
        type = "doughnut";
    }

    public DoughnutChartData(String id, String label, String action, String method, Integer refresh) {
        super(id, label, action, method, refresh);
        type = "doughnut";
        data = new ArrayList<DataSet>();
    }

    public List<DataSet> getData() {
        return Collections.unmodifiableList(data);
    }

    public void setData(List<DataSet> data) {
        this.data = data;
    }

    public void addData(DataSet ds) {
        data.add(ds);
    }

    /**
     *
     */
    public static class DataSet implements Serializable {
        private String bgColor;
        private Double value;
        private String label;

        public DataSet(String bgColor, Double value, String label) {
            this.bgColor = bgColor;
            this.value = value;
            this.label = label;
        }

        public String getBgColor() {
            return bgColor;
        }

        public void setBgColor(String bgColor) {
            this.bgColor = bgColor;
        }

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }
}
