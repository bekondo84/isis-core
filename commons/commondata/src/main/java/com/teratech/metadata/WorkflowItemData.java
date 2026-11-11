package com.teratech.metadata;

public class WorkflowItemData extends CardItemData
{
    protected String statecolor ;
    protected  Double amount ;

    public WorkflowItemData() {
    }

    public WorkflowItemData(String id, String name) {
        super(id, name);
    }

    public String getStatecolor() {
        return statecolor;
    }

    public WorkflowItemData setStatecolor(String statecolor) {
        this.statecolor = statecolor;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public WorkflowItemData setAmount(Double amount) {
        this.amount = amount;
        return this;
    }
}
