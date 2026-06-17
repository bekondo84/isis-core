package com.teratech.metadata;

import java.io.Serializable;

public class KabanViewData implements Serializable {

    private boolean creatable;
    private boolean deletable;
    private boolean viewable;
    private String template;

    public KabanViewData(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public boolean isCreatable() {
        return creatable;
    }

    public void setCreatable(boolean creatable) {
        this.creatable = creatable;
    }

    public boolean isDeletable() {
        return deletable;
    }

    public void setDeletable(boolean deletable) {
        this.deletable = deletable;
    }

    public boolean isViewable() {
        return viewable;
    }

    public void setViewable(boolean viewable) {
        this.viewable = viewable;
    }
}
