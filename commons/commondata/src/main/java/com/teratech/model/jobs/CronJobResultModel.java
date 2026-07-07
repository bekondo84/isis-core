package com.teratech.model.jobs;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "cron_result")
public class CronJobResultModel extends AbstractItem {
    public static final CronJobResultModel ERROR = new CronJobResultModel("ERROR");
    public static final CronJobResultModel FAILURE = new CronJobResultModel("FAILURE");
    public static final CronJobResultModel SUCCESS = new CronJobResultModel("SUCCESS");
    public static final CronJobResultModel UNKNOWN = new CronJobResultModel("UNKNOWN");

    @Id
    private String code ;
    private String description;


    public CronJobResultModel() {
    }

    public CronJobResultModel(String code) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CronJobResultModel that = (CronJobResultModel) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
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
}
