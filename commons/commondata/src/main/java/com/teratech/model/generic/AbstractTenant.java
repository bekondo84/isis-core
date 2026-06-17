package com.teratech.model.generic;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractTenant extends AbstractItem {

    @Column(name = "tenant_id", nullable = false)
    private String tenantId;

    public String getTenantId() {
        return tenantId;
    }
}
