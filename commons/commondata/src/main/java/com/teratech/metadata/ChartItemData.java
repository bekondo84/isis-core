package com.teratech.metadata;

public class ChartItemData extends CardItemData{
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
     * @param name
     * @param action
     * @param method
     * @param type
     * @param refresh
     */
    public ChartItemData(String id, String name, String action, String method, String type, Integer refresh) {
        super(id, name);
        this.action = action;
        this.method = method;
        this.type = type;
        this.refresh = refresh;
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
        return id != null && name != null && refresh != null && type != null && action != null && method != null;
    }
}
