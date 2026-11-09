package com.teratech.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChartsData extends AbstractDashboardSectionData{

    protected List<ChartItemData> items = new ArrayList<ChartItemData>();

    public ChartsData() {
    }

    /**
     *
     * @param name
     * @param label
     * @param position
     * @param columns
     * @param header
     */
    public ChartsData(String name, String label, Integer position, Integer columns, Boolean header) {
        super(name, label, position, columns, header);
    }

    public List<ChartItemData> getItems() {
        return Collections.unmodifiableList(items);
    }
    public void setItems(List<ChartItemData> items) {
        this.items = items;
    }

    public void addItem(ChartItemData item) {
        if (items.contains(item)) {
            this.items.add(item);
        }
    }

    public boolean isValid() {
        return !items.isEmpty() && super.isValid();
    }
}
