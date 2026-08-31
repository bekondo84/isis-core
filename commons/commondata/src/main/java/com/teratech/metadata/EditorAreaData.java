package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EditorAreaData implements Serializable {
    private FormData form ;
    private List<TabData> tabs ;
    private List<ActionData> actions;
    private List<ShutCutData> shutcuts;

    public EditorAreaData() {
        form = new FormData();
        tabs = new ArrayList<>();
        actions = new ArrayList<>();
        shutcuts = new ArrayList<>();
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

    public List<ActionData> getActions() {
        return Collections.unmodifiableList(actions);
    }

    public void setActions(List<ActionData> actions) {
        this.actions = actions;
    }
    public  void addAction(final ActionData action) {
        actions.add(action);
    }

    public List<ShutCutData> getShutcuts() {
        return shutcuts;
    }

    public void setShutcuts(List<ShutCutData> shutcuts) {
        this.shutcuts = shutcuts;
    }

    public void addShutcut(final ShutCutData shutcut) {
        shutcuts.add(shutcut);
    }
}
