package com.teratech.isis.services.impl;

import com.teratech.dao.FlexibleSearch;
import com.teratech.model.jobs.CronJobModel;
import com.teratech.tools.persistence.RestrictionsContainer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class DynamicJobSchedulerService {

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;
    @Autowired
    private CronJobEngineService engineService;
    @Autowired
    private FlexibleSearch flexibleSearch;
    @Autowired
    private Logger logger;

    //@EventListener(ContextRefreshedEvent.class)
    public void initAllScheduledJobs() {
         logger.info("Intializing Thread Pool --------------------------");
        try {
            RestrictionsContainer container = RestrictionsContainer.newInstance();
            container.addEq("actif", Boolean.TRUE);
            List<CronJobModel> activeJobs = flexibleSearch.doSearch(CronJobModel.class, container, new HashMap<>(), new HashSet<>(), 0, -1);
            logger.info(String.format("CronJobModel fetch : %s", activeJobs));
            for (CronJobModel job :  activeJobs) {
                scheduleJob (job);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void scheduleJob(CronJobModel job) {
       logger.info(String.format("Register Job %s With cron expression %s", job.getJob(), job.getCronExpression()));
        Runnable task = () -> engineService.executeJob(job);
        taskScheduler.schedule(task, new CronTrigger(job.getCronExpression()));
    }
}
