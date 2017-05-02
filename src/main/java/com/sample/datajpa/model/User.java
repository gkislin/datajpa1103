package com.sample.datajpa.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: gkislin
 */
@Entity
@Table(name = "users")
public class User extends AbstractPersistable<Integer> {

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Column
    private String mark;

    @Column
    private Integer bonus;

    @Column
    private String comment;

    public User() {
    }
}
