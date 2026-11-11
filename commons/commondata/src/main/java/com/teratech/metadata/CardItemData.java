package com.teratech.metadata;

import org.apache.commons.lang.StringUtils;

import java.util.Objects;

public class CardItemData extends AbstractDashboardItem {

    protected Double value;
    protected Float change;
    protected String scope;
    protected String currency;


    public CardItemData() {
    }

    public CardItemData(String id, String name) {
        super(id, name);
    }

    public Double getValue() {
        return value;
    }

    public CardItemData setValue(Double value) {
        this.value = value;
        return this;
    }

    public Float getChange() {
        return change;
    }

    public CardItemData setChange(Float change) {
        this.change = change;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public CardItemData setScope(String scope) {
        this.scope = scope;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public boolean isValid() {
        return StringUtils.isNotBlank(id)
                && StringUtils.isNotBlank(label);
    }
}
