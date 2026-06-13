package com.teratech.model.generic;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
public abstract class ItemModel implements Serializable {
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModif;

    public Date getCreatedAt() {
        return createdAt;
    }

    protected void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastModif() {
        return lastModif;
    }

    public void setLastModif(Date lastModif) {
        this.lastModif = lastModif;
    }
}
