package com.teratech.model.generic;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
public abstract class AbstractItem implements Serializable {

   // private String tenantid;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModif;

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getLastModif() {
        return lastModif;
    }

    public void setLastModif(Date lastModif) {
        this.lastModif = lastModif;
    }


}
