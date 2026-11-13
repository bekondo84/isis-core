package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BarChartData extends ChartItemData {
    protected List<String> labels;
    protected List<DataSet> dataSets;

    public BarChartData() {
        dataSets = new ArrayList<>();
       // type = "bar";
    }

    public BarChartData(String id, String name) {
        super(id, name);
        dataSets = new ArrayList<>();
       // type = "bar";
    }

    public BarChartData(String id, String label, String action, String method, Integer refresh) {
        super(id, label, action, method, refresh);
        dataSets = new ArrayList<>();
        //type = "bar";
    }

    public List<String> getLabels() {
        return labels;
    }

    public BarChartData setLabels(List<String> labels) {
        this.labels = labels;
        return this;
    }

    public List<DataSet> getDataSets() {
        return Collections.unmodifiableList(dataSets);
    }

    public BarChartData setDataSets(List<DataSet> dataSets) {
        this.dataSets = dataSets;
        return this;
    }

    public void addDataSet(DataSet dataSet) {
        dataSets.add(dataSet);
    }

    public void addLabel(String label) {
        this.labels.add(label);
    }

    @Override
    public boolean isValid() {
        return super.isValid();
    }

    public static  class DataSet implements Serializable {
        private String label;
        private List<Double> values;
        private String bgColor;

        public DataSet(String label, String bgColor) {
            this.label = label;
        }

        public DataSet() {
        }

        public String getLabel() {
            return label;
        }

        public DataSet setLabel(String label) {
            this.label = label;
            return this;
        }

        public List<Double> getValues() {
            return values;
        }

        public DataSet setValues(List<Double> values) {
            this.values = values;
            return this;
        }

        public String getBgColor() {
            return bgColor;
        }

        public DataSet setBgColor(String bgColor) {
            this.bgColor = bgColor;
            return this;
        }

        public void addValue(double value) {
            values.add(value);
        }
    }
}