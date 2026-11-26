package com.teratech.model.definition;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "adm_task_type")
public class TaskTypeModel extends AbstractItem {

    public static final TaskTypeModel STARTEVENT = new TaskTypeModel("STARTEVENT");
    public static final TaskTypeModel USERTASK = new TaskTypeModel("USERTASK");
    public static final TaskTypeModel SERVICETASK = new TaskTypeModel("SERVICETASK");
    public static final TaskTypeModel EXCLUSIVEGATEWAY = new TaskTypeModel("EXCLUSIVEGATEWAY");
    public static final TaskTypeModel PARALLELGATEWAY = new TaskTypeModel("PARALLELGATEWAY");
    public static final TaskTypeModel TIMEREVENT = new TaskTypeModel("TIMEREVENT");
    public static final TaskTypeModel INTERMEDIATECATCHEVENT = new TaskTypeModel("INTERMEDIATECATCHEVENT");
    public static final TaskTypeModel BOUNDARYEVENT = new TaskTypeModel("BOUNDARYEVENT");
    public static final TaskTypeModel ENDEVENT = new TaskTypeModel("ENDEVENT");

    @Id
    protected String code;
    protected String description;

    public TaskTypeModel(String code) {
        this.code = code;
    }

    public TaskTypeModel() {
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

    @Override
    public Object getPk() {
        return code;
    }

    @Override
    public void toStringValue() {
         stringValue = code;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskTypeModel that = (TaskTypeModel) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
}
