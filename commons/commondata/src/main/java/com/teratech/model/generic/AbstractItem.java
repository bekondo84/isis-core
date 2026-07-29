package com.teratech.model.generic;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@MappedSuperclass
public abstract class AbstractItem implements Serializable {

    @Column(insertable = false, updatable = false)
    private Long seqnumber;
    private LocalDateTime createdAt;
    private LocalDateTime lastModif;
    protected String stringValue;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastModif() {
        return lastModif;
    }

    public Long getSeqnumber() {
        return seqnumber;
    }

    public String getStringValue() {
        return stringValue;
    }

    /**
     * Retour the primary key object
     * @return
     */
    public abstract Object getPk();

    /**
     * Build and convert the entity in String
     */
    public abstract void toStringValue();

}
