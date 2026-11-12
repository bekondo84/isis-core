package com.teratech.metadata;

import java.io.Serializable;
import java.util.*;

public class LineChartData extends ChartItemData
{
    protected List<String> labels;
    protected List<LineChartItemData> datasets;

    public LineChartData() {
        type = "line";
        datasets = new ArrayList<>();
        labels = new ArrayList<>();
    }

    public LineChartData(String id, String name) {
        super(id, name);
        type = "line";
        datasets = new ArrayList<>();
        labels = new ArrayList<>();
    }

    public LineChartData(String id, String label, String action, String method, Integer refresh) {
        super(id, label, action, method, refresh);
        type = "line";
        datasets = new ArrayList<>();
    }

    public List<String> getLabels() {
        return Collections.unmodifiableList(labels);
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<LineChartItemData> getDatasets() {
        return Collections.unmodifiableList(datasets);
    }

    public void setDatasets(List<LineChartItemData> datasets) {
        this.datasets = datasets;
    }

    public void addDataset(LineChartItemData dataset) {
        datasets.add(dataset);
    }
    public void addLabel(String label) {
        labels.add(label);
    }

    public static class LineChartItemData implements Serializable {
        private String label;
        private String bgColor;
        private String pointColor;
        private String borderColor;
        private List<Double> values;

        /**
         *
         */
        public LineChartItemData() {
            values = new ArrayList<>();
        }

        /**
         *
         * @param label
         * @param bgColor
         * @param pointColor
         * @param borderColor
         */
        public LineChartItemData(String label, String bgColor, String pointColor, String borderColor) {
            this.label = label;
            this.bgColor = bgColor;
            this.pointColor = pointColor;
            this.borderColor = borderColor;
            values = new ArrayList<>();
        }

        public String getLabel() {
            return label;
        }

        public LineChartItemData setLabel(String label) {
            this.label = label;
            return this;
        }

        public String getBgColor() {
            return bgColor;
        }

        public LineChartItemData setBgColor(String bgColor) {
            this.bgColor = bgColor;
            return this;
        }

        public String getPointColor() {
            return pointColor;
        }

        public LineChartItemData setPointColor(String pointColor) {
            this.pointColor = pointColor;
            return this;
        }

        public String getBorderColor() {
            return borderColor;
        }

        public LineChartItemData setBorderColor(String borderColor) {
            this.borderColor = borderColor;
            return this;
        }

        public List<Double> getValues() {
            return Collections.unmodifiableList(values);
        }

        public void setValues(List<Double> values) {
            this.values = values;
        }

        public void addValue(Double value) {
            values.add(value);
        }
    }
}
