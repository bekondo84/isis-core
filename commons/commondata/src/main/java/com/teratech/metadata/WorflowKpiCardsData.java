package com.teratech.metadata;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class WorflowKpiCardsData extends AbstractDashboardSectionData{

    protected String action;
    protected String method;
    protected Integer refresh;
    protected  String resume;
    protected  String unit;

    protected List<WorkflowItemData> items;
    protected List<WorkflowKpiCardResume> resumes;

    public WorflowKpiCardsData() {
        type = "WorflowKpiCards";
        items = new ArrayList<>();
        resumes = new ArrayList<>();
    }

    public WorflowKpiCardsData(String action, String method, Integer refresh) {
        this.action = action;
        this.method = method;
        this.refresh = refresh;
        type = "WorflowKpiCards";
        items = new ArrayList<>();
        resumes = new ArrayList<>();
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
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

    public List<WorkflowItemData> getItems() {
        return items;
    }

    public void setItems(List<WorkflowItemData> items) {
        this.items = items;
    }

    public void addItem(WorkflowItemData item){
        items.add(item);
    }

    public List<WorkflowKpiCardResume> getResumes() {
        return resumes;
    }

    public void setResumes(List<WorkflowKpiCardResume> resumes) {
        this.resumes = resumes;
    }

    public void addResume(WorkflowKpiCardResume resume){
        resumes.add(resume);
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean isValid() {
        return !items.isEmpty()
                && StringUtils.isNotBlank(action)
                && StringUtils.isNotBlank(method)
                && refresh != null
                && super.isValid()
                && type.equals("WorflowKpiCards");
    }
}
