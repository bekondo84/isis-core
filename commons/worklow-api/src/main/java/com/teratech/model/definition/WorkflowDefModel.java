package com.teratech.model.definition;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;

@Entity
@Table(name = "adm_wf_def")
public  class WorkflowDefModel extends AbstractItem
{
	@Id
	protected String id;
	protected String name;
	protected String version;
	protected boolean executable;
	protected String template;

	public WorkflowDefModel() {
	}

	public String getId() {
		return id;
	}

	public WorkflowDefModel setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public WorkflowDefModel setName(String name) {
		this.name = name;
		return this;
	}

	public String getVersion() {
		return version;
	}

	public WorkflowDefModel setVersion(String version) {
		this.version = version;
		return this;
	}

	public boolean isExecutable() {
		return executable;
	}

	public WorkflowDefModel setExecutable(boolean executable) {
		this.executable = executable;
		return this;
	}

	public String getTemplate() {
		return template;
	}

	public WorkflowDefModel setTemplate(String template) {
		this.template = template;
		return this;
	}

	@Override
	public Object getPk() {
		return id;
	}

	@Override
	public void toStringValue() {
         stringValue = name;
	}
}
