package com.teratech.model.security;

import com.teratech.model.generic.AbstractItem;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table (name = "bs_rigth")
public class UserRigthModel extends AbstractItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code ;
    private String name;
    @Column(name = "can_read")
    private Boolean read;
     @Column(name = "can_write")
    private Boolean write;
     @Column(name = "can_delete")
    private Boolean delete ;

    public UserRigthModel() {
    }

    public UserRigthModel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Boolean getWrite() {
        return write;
    }

    public void setWrite(Boolean write) {
        this.write = write;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRigthModel that = (UserRigthModel) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    /**
     * Retour the primary key object
     *
     * @return
     */
    @Override
    public Object getPk() {
        return id;
    }
}
