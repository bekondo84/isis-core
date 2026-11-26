package com.teratech.model;


import com.teratech.model.definition.WorkflowDefModel;
import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;

//@Entity
//@Table(name = "adm_wf")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "wf_type" , discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractWorkflow extends AbstractItem {

    @Id
    protected String code ;
    protected String name;
    @ManyToOne
    @JoinColumn(name = "wf_def")
    protected WorkflowDefModel workflow;

    public String getCode() {
        return code;
    }

    public AbstractWorkflow setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public AbstractWorkflow setName(String name) {
        this.name = name;
        return this;
    }

    public WorkflowDefModel getWorkflow() {
        return workflow;
    }

    public AbstractWorkflow setWorkflow(WorkflowDefModel workflow) {
        this.workflow = workflow;
        return this;
    }
}
