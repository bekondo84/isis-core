package com.teratech.model.settings;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "adm_currency")
public class CurrencyModel extends AbstractItem {
    @Id
    private String code;
    @Column(nullable = false)
    private String symbol;
    private float arrondi;
    @Column(name = "precisio")
    private int precision;
    private boolean base;
    private boolean active;

    public CurrencyModel() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public float getArrondi() {
        return arrondi;
    }

    public void setArrondi(float arrondi) {
        this.arrondi = arrondi;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public boolean isBase() {
        return base;
    }

    public void setBase(boolean base) {
        this.base = base;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public Object getPk() {
        return code;
    }

    @Override
    public void toStringValue() {
        stringValue = code;
    }
}
