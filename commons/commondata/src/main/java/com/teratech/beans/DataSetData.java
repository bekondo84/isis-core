package com.teratech.beans;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class DataSetData implements Serializable {
    protected List<String> bgColors;
    protected List<Object> values ;

    public DataSetData() {
    }

    public List<String> getBgColors() {
        return Collections.unmodifiableList(bgColors);
    }

    public DataSetData setBgColors(List<String> bgColors) {
        this.bgColors = bgColors;
        return this;
    }

    public List<Object> getValues() {
        return Collections.unmodifiableList(values);
    }

    public DataSetData setValues(List<Object> values) {
        this.values = values;
        return this;
    }
    DataSetData addValue(final Object value) {
        values.add(value);
        return this;
    }
    DataSetData addBgColor(final String color) {
        bgColors.add(color);
        return this;
    }
}
