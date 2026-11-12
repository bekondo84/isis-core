package com.teratech.metadata;

public class ChartItemData extends AbstractDashboardItem{
    protected String action;
    protected String method;
    protected String type;
    protected Integer refresh;

    public ChartItemData() {
    }

    public ChartItemData(String id, String name) {
        super(id, name);
    }

    /**
     *
     * @param id
     * @param label
     * @param action
     * @param method
     * @param refresh
     */
    public ChartItemData(String id, String label, String action, String method, Integer refresh) {
        super(id, label);
        this.action = action;
        this.method = method;
        this.refresh = refresh;
        this.type = "chart";
    }

    public String getAction() {
        return action;
    }

    public ChartItemData setAction(String action) {
        this.action = action;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public ChartItemData setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getType() {
        return type;
    }

    public ChartItemData setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getRefresh() {
        return refresh;
    }

    public ChartItemData setRefresh(Integer refresh) {
        this.refresh = refresh;
        return this;
    }

    public boolean isValid() {
        return id != null && label != null && refresh != null && type != null && action != null && method != null;
    }
}
