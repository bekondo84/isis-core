package com.teratech.job;

import com.teratech.extensions.JobPerformable;
import com.teratech.jobs.PerformResult;
import com.teratech.model.jobs.CronJobModel;
import com.teratech.model.jobs.CronJobResultModel;
import com.teratech.model.jobs.CronJobStateModel;
import org.pf4j.Extension;
import org.springframework.stereotype.Component;

@Extension
@Component
public class HelloWordJob implements JobPerformable<CronJobModel> {
    /**
     * @param cronJob
     * @return
     */
    @Override
    public PerformResult perform(CronJobModel cronJob) {
        System.out.println("Hello I am the Hello word job ..........");
        return new PerformResult(CronJobResultModel.SUCCESS, CronJobStateModel.FINISHED);
    }

    /**
     * Id of the Job, mapped with the job field of the CronJobModel
     *
     * @return
     */
    @Override
    public String job() {
        return "helloWordJob";
    }
}
