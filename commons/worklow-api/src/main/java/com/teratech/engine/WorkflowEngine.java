package com.teratech.engine;

import com.teratech.model.AbstractWorkflow;
import com.teratech.model.definition.WorkflowDefModel;

public interface WorkflowEngine {

      <T extends AbstractWorkflow> void execute(T workflow, WorkflowDefModel definition) throws Exception;
}
