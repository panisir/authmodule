package com.melo.authmodule.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PrePersist
    protected void prePersist() {
        if (this.createdAt == null) createdAt = new Timestamp(System.currentTimeMillis());
        if (this.updatedAt == null) updatedAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
