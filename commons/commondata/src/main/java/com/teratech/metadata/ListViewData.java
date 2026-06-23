package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListViewData implements Serializable {

    private boolean creatable;
    private boolean deletable;
    private boolean viewable;
    private List<MetaColumn> columns;
    private List<SearchColumn> search;
    private List<ActionData> actions;

    public ListViewData() {
        this.search = new ArrayList<>();
        columns = new ArrayList<>();
        actions = new ArrayList<>();
        this.creatable = true;
        this.deletable = true;
        this.viewable = true;
    }

    public List<MetaColumn> getColumns() {
        return  Collections.unmodifiableList(columns);
    }

    public void setColumns(List<MetaColumn> columns) {
        this.columns =columns;
    }

    public List<SearchColumn> getSearch() {
        return Collections.unmodifiableList(search);
    }

    public void setSearch(List<SearchColumn> search) {
        this.search = search;
    }

    public void addColumn(final MetaColumn item) {
        this.columns.add(item);
    }
    public void addSearch(final SearchColumn item) {
        this.search.add(item);
    }

    public List<ActionData> getActions() {
        return Collections.unmodifiableList(actions);
    }

    public void setActions(List<ActionData> actions) {
        this.actions = actions;
    }
    public  void addAction(final ActionData action) {
        actions.add(action);
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
