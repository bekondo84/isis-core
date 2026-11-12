package com.teratech.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class BarChartData extends ChartItemData {
    protected String bgColor;
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

    public String getBgColor() {
        return bgColor;
    }

    public BarChartData setBgColor(String bgColor) {
        this.bgColor = bgColor;
        return this;
    }

    public List<DataSet> getDataSets() {
        return Collections.unmodifiableList(dataSets);
    }

    public void setDataSets(List<DataSet> dataSets) {
        this.dataSets = dataSets;
    }

    public void addDataSet(DataSet dataSet) {
        dataSets.add(dataSet);
    }

    @Override
    public boolean isValid() {
        return super.isValid();
    }

    public static  class DataSet extends HashMap<String,Double> {

    }
}