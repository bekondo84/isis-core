package com.teratech.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShutCutsData implements Serializable {
    private String visibleWhen;
    private List<ShutCutData> shutcuts = new ArrayList<>();

    public String getVisibleWhen() {
        return visibleWhen;
    }

    public void setVisibleWhen(String visibleWhen) {
        this.visibleWhen = visibleWhen;
    }

    public List<ShutCutData> getShutcuts() {
        return Collections.unmodifiableList(shutcuts);
    }

    public void setShutcuts(List<ShutCutData> shutcuts) {
        this.shutcuts = shutcuts;
    }

    public void addShutcut(ShutCutData shutcut) {
        this.shutcuts.add(shutcut);
    }
}
