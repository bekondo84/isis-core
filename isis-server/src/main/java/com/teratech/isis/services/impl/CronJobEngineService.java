package com.teratech.isis.services.impl;

import com.teratech.dao.PersistenceManager;
import com.teratech.extensions.JobPerformable;
import com.teratech.jobs.PerformResult;
import com.teratech.model.jobs.CronJobHistoryModel;
import com.teratech.model.jobs.CronJobModel;
import com.teratech.model.jobs.CronJobResultModel;
import com.teratech.model.jobs.CronJobStateModel;
import org.apache.commons.lang.StringUtils;
import org.pf4j.PluginManager;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CronJobEngineService {

    @Autowired
    private PluginManager pluginManager;
    @Autowired
    private Logger logger;
    @Autowired
    private PersistenceManager persistenceManager;
    @Autowired
    private TransactionTemplate transactionTemplate;

    public void executeJob (CronJobModel jobConfig)  {
        //logger.info("Executr Job =========== "+jobConfig.isActif());
        transactionTemplate.execute(status -> {
            executeJobmethod(jobConfig);
            return true;
        });

    }

    /**
     *
     * @param jobConfig
     */
    private void executeJobmethod(CronJobModel jobConfig) {
        if (Objects.isNull(jobConfig.isActif())
          || !jobConfig.isActif()) {
            return;
        }
        
        List<JobPerformable> availableJobs = pluginManager.getExtensions(JobPerformable.class, jobConfig.getPlugin().getId());
        if (CollectionUtils.isEmpty(availableJobs)) {
            logger.info(String.format("No JobPerformable extension found for plugin %s", jobConfig.getPlugin().getId()));
            return;
        }

        Optional<JobPerformable> jobPerformable = availableJobs.stream().
                filter(job -> StringUtils.isNotBlank(job.job()) && job.job().equals(jobConfig.getJob())).findAny();
        if (jobPerformable.isEmpty()) {
            logger.info(String.format("No JobPerformable extension with Id %s found for plugin %s", jobConfig.getJob(), jobConfig.getPlugin().getId()));
            return;
        }

        PerformResult result = new PerformResult(CronJobResultModel.UNKNOWN, CronJobStateModel.RUNNING);
        final CronJobHistoryModel jobHistory = new CronJobHistoryModel();
        jobHistory.setId(null);

        try {
            beforeProcess (jobConfig, result, jobHistory);
            result = jobPerformable.get().perform(jobConfig);
            //afterProcess (jobConfig, result, jobHistory);
        } catch (Exception e) {
            result.setResult(CronJobResultModel.ERROR);
            result.setState(CronJobStateModel.UNKNOWN);
            jobHistory.setMessage(e.getMessage());
        } finally {
            afterProcess(jobConfig, result, jobHistory);
        }
    }

    /**
     * Action to execute before call the job
     * @param jobConfig
     */
    private void afterProcess(CronJobModel jobConfig, PerformResult result, CronJobHistoryModel history)  {

        try {
            jobConfig.setState(result.getState());
            jobConfig.setResult(result.getResult());
            persistenceManager.save(jobConfig);
            history.setEndAt(LocalDateTime.now());
            history.setStatus(result.getState().getCode());
            //history.setMessage(String.);
            persistenceManager.save(history);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param jobConfig
     */
    private void beforeProcess(CronJobModel jobConfig, PerformResult result, CronJobHistoryModel history) {
        //Reinitialse the CronJob State and Result
        jobConfig.setState(result.getState());
        jobConfig.setResult(result.getResult());
        history.setCronJob(jobConfig);
        history.setStartAt(LocalDateTime.now());
    }
}
