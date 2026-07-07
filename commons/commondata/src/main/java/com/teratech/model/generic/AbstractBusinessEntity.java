package com.teratech.model.generic;

import com.teratech.model.security.BusinessModel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractBusinessEntity extends AbstractItem {

    @ManyToOne
    @JoinColumn(name = "business", referencedColumnName = "code")
    private BusinessModel business;

    public BusinessModel getBusiness() {
        return business;
    }

    private void setBusiness(BusinessModel business) {
        this.business = business;
    }
}
