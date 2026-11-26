package com.teratech.model.definition;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;

@Entity
@Table(name = "adm_seq_flow")
public class SequenceFlowDefModel extends AbstractItem {

    @Id
    protected String id;
    protected TaskDefModel sourceRef;
    protected TaskDefModel targetRef;
    protected String condition ;
    protected boolean standard;
    @ManyToOne
    @JoinColumn(name = "wf_def")
    protected  WorkflowDefModel workflow;

    public SequenceFlowDefModel() {
    }

    /**
     *
     * @param id
     */
    public SequenceFlowDefModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public SequenceFlowDefModel setId(String id) {
        this.id = id;
        return this;
    }

    public TaskDefModel getSourceRef() {
        return sourceRef;
    }

    public SequenceFlowDefModel setSourceRef(TaskDefModel sourceRef) {
        this.sourceRef = sourceRef;
        return this;
    }

    public TaskDefModel getTargetRef() {
        return targetRef;
    }

    public SequenceFlowDefModel setTargetRef(TaskDefModel targetRef) {
        this.targetRef = targetRef;
        return this;
    }

    public String getCondition() {
        return condition;
    }

    public SequenceFlowDefModel setCondition(String condition) {
        this.condition = condition;
        return this;
    }

    public boolean isStandard() {
        return standard;
    }

    public SequenceFlowDefModel setStandard(boolean standard) {
        this.standard = standard;
        return this;
    }

    public WorkflowDefModel getWorkflow() {
        return workflow;
    }

    public SequenceFlowDefModel setWorkflow(WorkflowDefModel workflow) {
        this.workflow = workflow;
        return this;
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
