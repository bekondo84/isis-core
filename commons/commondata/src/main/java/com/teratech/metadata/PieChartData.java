package com.teratech.metadata;

public class PieChartData extends DoughnutChartData
{
    public PieChartData() {
        type = "pie";
    }

    public PieChartData(String id, String name) {
        super(id, name);
        type = "pie";
    }

    public PieChartData(String id, String label, String action, String method, Integer refresh) {
        super(id, label, action, method, refresh);
        type = "pie";
    }
}
