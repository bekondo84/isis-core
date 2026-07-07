package com.teratech.model.jobs;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "cron_history")
public class CronJobHistoryModel extends AbstractItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "start_at")
    private LocalDateTime startAt;
    //@NotNull
    @Column(name = "end_at")
    private LocalDateTime endAt;
    private String message;
    private String status;
    @ManyToOne
    @JoinColumn(name = "cron_id", referencedColumnName = "id")
    private CronJobModel cronJob ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CronJobModel getCronJob() {
        return cronJob;
    }

    public void setCronJob(CronJobModel cronJob) {
        this.cronJob = cronJob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CronJobHistoryModel that = (CronJobHistoryModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
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
}
