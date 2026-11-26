package com.teratech.model.definition;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "adm_timer_cycle")
public class TimerCycleModel extends AbstractItem {
    public static final TimerCycleModel DATE =  new TimerCycleModel("DATE");
    public static final TimerCycleModel DURATION = new TimerCycleModel("DURATION");
    public static final TimerCycleModel CYCLE = new TimerCycleModel("CYCLE");

    @Id
    protected String code ;
    protected String description;

    public TimerCycleModel() {
    }

    public TimerCycleModel(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public TimerCycleModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TimerCycleModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public Object getPk() {
        return code;
    }

    @Override
    public void toStringValue() {
           stringValue = description;
    }
}
