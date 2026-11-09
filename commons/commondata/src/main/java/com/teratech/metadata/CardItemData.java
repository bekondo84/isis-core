package com.teratech.metadata;

import java.io.Serializable;
import java.util.Objects;

public class CardItemData implements Serializable {
    protected  String id;
    protected String name;

    public CardItemData() {
    }

    public CardItemData(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isValid() {
        return id != null && name != null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CardItemData that = (CardItemData) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
