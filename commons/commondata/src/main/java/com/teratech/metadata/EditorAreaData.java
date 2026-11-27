package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EditorAreaData implements Serializable {
    private FormData form ;
    private List<TabData> tabs ;
    private ActionsData actions;
    private ShutCutsData shutcuts;
    private StatesData states;

    public EditorAreaData() {
        form = new FormData();
        tabs = new ArrayList<>();
    }

    public FormData getForm() {
        return form;
    }

    public void setForm(FormData form) {
        this.form = form;
    }

    public List<TabData> getTabs() {
        return tabs;
    }

    public void addTab(final TabData tab) {
        tabs.add(tab);
    }
    public void setTabs(List<TabData> tabs) {
        this.tabs = Collections.unmodifiableList(tabs);
    }

    public StatesData getStates() {
        return states;
    }

    public void setStates(StatesData states) {
        this.states = states;
    }

    public ActionsData getActions() {
        return actions;
    }

    public EditorAreaData setActions(ActionsData actions) {
        this.actions = actions;
        return this;
    }

    public ShutCutsData getShutcuts() {
        return shutcuts;
    }

    public EditorAreaData setShutcuts(ShutCutsData shutcuts) {
        this.shutcuts = shutcuts;
        return this;
    }
}
