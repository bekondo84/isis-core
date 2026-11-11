package com.teratech.metadata;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KpiCardsData extends AbstractDashboardSectionData {

    protected String action;
    protected String method;
    protected Integer refresh;

    protected List<CardItemData> items;

    public KpiCardsData() {
        items = new ArrayList<>();
        type = "kpiCards";
    }

    public KpiCardsData(String action, String method, Integer refresh) {
        this.action = action;
        this.method = method;
        this.refresh = refresh;
        type = "kpiCards";
        items = new ArrayList<>();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getRefresh() {
        return refresh;
    }

    public void setRefresh(Integer refresh) {
        this.refresh = refresh;
    }
    public List<CardItemData> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void setItems(List<CardItemData> items) {
        this.items = items;
    }

    public void addItem(CardItemData item){
        if (!items.contains(item)) {
            items.add(item);
        }
    }

    public boolean isValid(){
        return !items.isEmpty()
                && StringUtils.isNotBlank(action)
                && StringUtils.isNotBlank(method)
                && refresh != null
                && super.isValid()
                && type.equals("kpiCards");
    }
}
