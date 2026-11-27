package com.teratech.model.definition;

import com.teratech.model.PluginModel;
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
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "plugin_id", referencedColumnName = "id"),
			@JoinColumn(name = "version_id", referencedColumnName = "version")
	})
	protected PluginModel plugin;

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

	public PluginModel getPlugin() {
		return plugin;
	}

	public WorkflowDefModel setPlugin(PluginModel plugin) {
		this.plugin = plugin;
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
