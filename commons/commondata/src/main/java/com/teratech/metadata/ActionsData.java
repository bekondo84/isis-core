package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActionsData implements Serializable {
    private String visibleWhen;
    private List<ActionData> actions = new ArrayList<>();

    public ActionsData() {
    }

    public List<ActionData> getActions() {
        return Collections.unmodifiableList(actions);
    }

    public void setActions(List<ActionData> actions) {
        this.actions = actions;
    }

    public void addAction(ActionData action) {
        this.actions.add(action);
    }

    public String getVisibleWhen() {
        return visibleWhen;
    }

    public void setVisibleWhen(String visibleWhen) {
        this.visibleWhen = visibleWhen;
    }
}
