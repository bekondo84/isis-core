package com.teratech.extensions;

import com.teratech.jobs.PerformResult;
import com.teratech.model.jobs.CronJobModel;
import org.pf4j.ExtensionPoint;

/**
 * ExtensionPoint for Job
 * Every Job must implement this extension
 * @param <T>
 */
public interface JobPerformable <T extends CronJobModel> extends ExtensionPoint {

    /**
     *
     * @param cronJob
     * @return
     */
    PerformResult perform(T cronJob);

    /**
     * Check if the Job is abortable
     * @return
     */
    default boolean isAbortable() {
        return false;
    }

    default boolean canAbort(final T cronJob) {
        return cronJob.isAbort();
    }

    /**
     * Id of the Job, mapped with the job field of the CronJobModel
     * @return
     */
    String job() ;
}
