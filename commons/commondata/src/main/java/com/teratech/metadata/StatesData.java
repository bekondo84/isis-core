package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatesData implements Serializable {

    protected String field;
    protected String visibleWhen;

    protected List<StateData> states = new ArrayList<>();

    public StatesData() {
    }

    public String getVisibleWhen() {
        return visibleWhen;
    }

    public void setVisibleWhen(String visibleWhen) {
        this.visibleWhen = visibleWhen;
    }

    public List<StateData> getStates() {
        return Collections.unmodifiableList(states);
    }

    public void setStates(List<StateData> states) {
        this.states = states;
    }

    public void addState(StateData stateData) {
        this.states.add(stateData);
    }

    public String getField() {
        return field;
    }
    public StatesData setField(String field) {
        this.field = field;
        return this;
    }

    public static final class StateData implements Serializable {
        private String code;
        private String name;
        private String color;
        private String visibleWhen;

        public StateData() {
        }

        public StateData(String code, String name, String color) {
            this.code = code;
            this.name = name;
            this.color = color;
        }

        public String getCode() {
            return code;
        }

        public StateData setCode(String code) {
            this.code = code;
            return this;
        }

        public String getName() {
            return name;
        }

        public StateData setName(String name) {
            this.name = name;
            return this;
        }

        public String getColor() {
            return color;
        }

        public StateData setColor(String color) {
            this.color = color;
            return this;
        }

        public String getVisibleWhen() {
            return visibleWhen;
        }

        public StateData setVisibleWhen(String visibleWhen) {
            this.visibleWhen = visibleWhen;
            return this;
        }
    }
}
