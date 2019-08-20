package com.yeting.multisource.db.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
@NoArgsConstructor
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Version
    @Column(name = "version")
    protected Integer version;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updateTime;

    @PrePersist
    void createdAt() {
        this.createTime = this.updateTime = new Date();
    }

    @PreUpdate
    void updatedAt() {
        this.updateTime = new Date();
    }
}
