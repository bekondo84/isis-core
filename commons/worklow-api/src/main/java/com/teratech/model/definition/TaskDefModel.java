package com.teratech.model.definition;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "adm_task_def")
public class TaskDefModel extends AbstractItem {

    @Id
    protected String id ;
    protected String name ;
    @ManyToOne
    @JoinColumn(name = "task_type")
    protected TaskTypeModel taskType ; //startevent, userTask, serviceTask, exclusiveGateway, parallelGateway, timerEvent, intermediateCatchEvent, boundaryEvent, endEvent
    protected String description ;
    protected String assignee ;
    protected String candidateGroup;
    protected LocalDateTime dueDate;
    protected String handler;
    protected boolean async;
    protected Integer retryCount;
    @ManyToOne
    @JoinColumn(name = "task_cycle")
    protected TimerCycleModel cycle; //Date ; duration; cycle
    protected String timeExpression;
    protected Integer duration;
    @ManyToOne
    @JoinColumn(name = "event_type")
    protected EventTypeModel eventType; // Time Event, Message Event, Signal Event
    protected String messageRef;
    protected String correlationKey;
    protected String signalRef;
    protected String attachedToRef;
    protected boolean cancelActivity;
    @ManyToOne
    @JoinColumn(name = "wf_def")
    protected WorkflowDefModel workflow;

    public TaskDefModel() {
    }

    public String getId() {
        return id;
    }

    public TaskDefModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskDefModel setName(String name) {
        this.name = name;
        return this;
    }

    public TaskTypeModel getTaskType() {
        return taskType;
    }

    public TaskDefModel setTaskType(TaskTypeModel taskType) {
        this.taskType = taskType;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskDefModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAssignee() {
        return assignee;
    }

    public TaskDefModel setAssignee(String assignee) {
        this.assignee = assignee;
        return this;
    }

    public String getCandidateGroup() {
        return candidateGroup;
    }

    public TaskDefModel setCandidateGroup(String candidateGroup) {
        this.candidateGroup = candidateGroup;
        return this;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public TaskDefModel setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getHandler() {
        return handler;
    }

    public TaskDefModel setHandler(String handler) {
        this.handler = handler;
        return this;
    }

    public boolean getAsync() {
        return async;
    }

    public TaskDefModel setAsync(boolean async) {
        this.async = async;
        return this;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public TaskDefModel setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
        return this;
    }

    public TimerCycleModel getCycle() {
        return cycle;
    }

    public TaskDefModel setCycle(TimerCycleModel cycle) {
        this.cycle = cycle;
        return this;
    }

    public String getTimeExpression() {
        return timeExpression;
    }

    public TaskDefModel setTimeExpression(String timeExpression) {
        this.timeExpression = timeExpression;
        return this;
    }

    public EventTypeModel getEventType() {
        return eventType;
    }

    public TaskDefModel setEventType(EventTypeModel eventType) {
        this.eventType = eventType;
        return this;
    }

    public String getMessageRef() {
        return messageRef;
    }

    public TaskDefModel setMessageRef(String messageRef) {
        this.messageRef = messageRef;
        return this;
    }

    public String getCorrelationKey() {
        return correlationKey;
    }

    public TaskDefModel setCorrelationKey(String correlationKey) {
        this.correlationKey = correlationKey;
        return this;
    }

    public String getSignalRef() {
        return signalRef;
    }

    public TaskDefModel setSignalRef(String signalRef) {
        this.signalRef = signalRef;
        return this;
    }

    public String getAttachedToRef() {
        return attachedToRef;
    }

    public TaskDefModel setAttachedToRef(String attachedToRef) {
        this.attachedToRef = attachedToRef;
        return this;
    }

    public boolean isCancelActivity() {
        return cancelActivity;
    }

    public TaskDefModel setCancelActivity(boolean cancelActivity) {
        this.cancelActivity = cancelActivity;
        return this;
    }

    public WorkflowDefModel getWorkflow() {
        return workflow;
    }

    public TaskDefModel setWorkflow(WorkflowDefModel workflow) {
        this.workflow = workflow;
        return this;
    }

    public boolean isAsync() {
        return async;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public Object getPk() {
        return id;
    }

    @Override
    public void toStringValue() {
           stringValue = id;
    }
}
