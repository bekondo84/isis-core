package com.teratech.model.jobs;

import com.teratech.model.PluginModel;
import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "cron_job")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "cron_type", discriminatorType = DiscriminatorType.STRING)
public class CronJobModel extends AbstractItem {

    @Id
    private String id ;
    private String description;
    @NotNull
    private String job;
    @Column(name = "cron_expression")
    private String cronExpression;
    private boolean actif = true;
    @Column(name = "last_execution")
    private LocalDateTime lastExecution;
    @Column (name = "next_execution")
    private LocalDateTime nextExecution;
    private Integer priority;
    private boolean abort = false;
    @ManyToOne
    @JoinColumn(name = "state", referencedColumnName = "code")
    private CronJobStateModel state ;
    @ManyToOne
    @JoinColumn(name = "result", referencedColumnName = "code")
    private CronJobResultModel result;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "plugin_id", referencedColumnName = "id"),
            @JoinColumn(name = "plugin_version", referencedColumnName = "version")
    })
    private PluginModel plugin;
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "cronJob")
    private List<CronJobHistoryModel> histories = new ArrayList<>();

    public CronJobModel() {
    }

    public CronJobModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public LocalDateTime getLastExecution() {
        return lastExecution;
    }

    public void setLastExecution(LocalDateTime lastExecution) {
        this.lastExecution = lastExecution;
    }

    public LocalDateTime getNextExecution() {
        return nextExecution;
    }

    public void setNextExecution(LocalDateTime nextExecution) {
        this.nextExecution = nextExecution;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public boolean isAbort() {
        return abort;
    }

    public void setAbort(boolean abort) {
        this.abort = abort;
    }

    public CronJobStateModel getState() {
        return state;
    }

    public void setState(CronJobStateModel state) {
        this.state = state;
    }

    public CronJobResultModel getResult() {
        return result;
    }

    public void setResult(CronJobResultModel result) {
        this.result = result;
    }

    public PluginModel getPlugin() {
        return plugin;
    }

    public void setPlugin(PluginModel plugin) {
        this.plugin = plugin;
    }

    public List<CronJobHistoryModel> getHistories() {
        return Collections.unmodifiableList(histories);
    }

    public void setHistories(List<CronJobHistoryModel> histories) {
        this.histories = histories;
    }

    public void addHistory (CronJobHistoryModel history) {
        histories.add(history);
    }
    /**
     * Retour the primary key object
     *
     * @return
     */
    @Override
    public Object getPk() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CronJobModel that = (CronJobModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
