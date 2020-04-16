package com.fss.empdb.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "ROLE_ID")
    Long roleId;

    public Role() {

    }

    @Column(name = "ROLE_NAME", nullable = false)
    String roleName;
}



