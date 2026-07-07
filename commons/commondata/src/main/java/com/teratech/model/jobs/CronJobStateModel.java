package com.teratech.model.jobs;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "cron_state")
public class CronJobStateModel extends AbstractItem {

    public final static CronJobStateModel FINISHED =new CronJobStateModel("FINISHED");
    public final static CronJobStateModel ABORTED =new CronJobStateModel("ABORTED");
    public final static CronJobStateModel PAUSED =new CronJobStateModel("PAUSED");
    public final static CronJobStateModel RUNNING =new CronJobStateModel("RUNNING");
    public final static CronJobStateModel UNKNOWN =new CronJobStateModel("UNKNOWN");
    public final static CronJobStateModel CREATE =new CronJobStateModel("CREATE");

    @Id
    private String code;
    private String description;

    public CronJobStateModel() {
    }

    /**
     *
     * @param code
     */
    public CronJobStateModel(String code) {
        this.code = code;
       // this.description = description;
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
        CronJobStateModel that = (CronJobStateModel) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
}
