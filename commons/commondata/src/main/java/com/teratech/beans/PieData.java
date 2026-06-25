package com.teratech.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PieData implements Serializable {
    protected List<String> labels ;
    protected DataSetData datasets ;

    public PieData() {
        labels = new ArrayList<>();
    }

    public List<String> getLabels() {
        return labels;
    }

    public PieData setLabels(List<String> labels) {
        this.labels = labels;
        return this;
    }

    public DataSetData getDatasets() {
        return datasets;
    }

    public PieData setDatasets(DataSetData datasets) {
        this.datasets = datasets;
        return this;
    }
    public PieData addLabel(final String label) {
        labels.add(label);
        return this;
    }
}
