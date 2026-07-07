package com.teratech.jobs;

import com.teratech.model.jobs.CronJobResultModel;
import com.teratech.model.jobs.CronJobStateModel;

import java.io.Serializable;

public class PerformResult implements Serializable {

    private CronJobResultModel result;
    private CronJobStateModel  state;


    /**
     *
     * @param result
     * @param state
     */
    public PerformResult(CronJobResultModel result, CronJobStateModel state) {
        this.result = result;
        this.state = state;
    }

    public CronJobResultModel getResult() {
        return result;
    }

    public void setResult(CronJobResultModel result) {
        this.result = result;
    }

    public CronJobStateModel getState() {
        return state;
    }

    public void setState(CronJobStateModel state) {
        this.state = state;
    }
}
