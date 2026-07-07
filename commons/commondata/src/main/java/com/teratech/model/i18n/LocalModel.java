package com.teratech.model.i18n;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table (name = "bs_local")
public class LocalModel extends AbstractItem {

    @Id
    private String code ;
    private String description;
    @Column(name = "separatord")
    private Character decimal;
    private Character thousand;
    private String dateformat ;
    private String timeformat;

    public LocalModel() {
    }

    public LocalModel(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getDecimal() {
        return decimal;
    }

    public void setDecimal(Character decimal) {
        this.decimal = decimal;
    }

    public Character getThousand() {
        return thousand;
    }

    public void setThousand(Character thousand) {
        this.thousand = thousand;
    }

    public String getDateformat() {
        return dateformat;
    }

    public void setDateformat(String dateformat) {
        this.dateformat = dateformat;
    }

    public String getTimeformat() {
        return timeformat;
    }

    public void setTimeformat(String timeformat) {
        this.timeformat = timeformat;
    }

    /**
     * Retour the primary key object
     *
     * @return
     */
    @Override
    public Object getPk() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalModel that = (LocalModel) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
}
