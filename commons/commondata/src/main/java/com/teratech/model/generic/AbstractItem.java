package com.teratech.model.generic;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;


@MappedSuperclass
public abstract class AbstractItem implements Serializable {

   // private String tenantid;

    //@Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private LocalDateTime createdAt;

    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastModif;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastModif() {
        return lastModif;
    }

}
