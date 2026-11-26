package com.teratech.model.definition;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "adm_event_type")
public class EventTypeModel extends AbstractItem {
    public static final EventTypeModel TIMEEVENT = new EventTypeModel("TIMEEVENT");
    public static final EventTypeModel MESSAGEEVENT = new EventTypeModel("MESSAGEEVENT");
    public static final EventTypeModel SIGNALVENT = new EventTypeModel("SIGNALVENT");

    @Id
    protected String code ;
    protected String description;

    public EventTypeModel() {
    }

    public EventTypeModel(String code) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public EventTypeModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public EventTypeModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public Object getPk() {
        return code;
    }

    @Override
    public void toStringValue() {
         stringValue =  description ;
    }
}
