package com.fss.empdb.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Department {

    @Id
    @Column(name = "DEPARTMENT_ID")
    Long departmentId;

    public Department(){}

    @Column(name = "DEPARTMENT_NAME")
    String departmentName;

    @Column(name = "DEPARTMENT_HEAD")
    String departmentHead;

    @Column(name="INS_USER",nullable = false)
    Long insUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="INS_DATE",nullable = false)
    Date insDate;

    @Column(name="LAST_UPDATE_USER")
    Long lastUpdUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LAST_UPDATE_DATE")
    Date lastUpdDate;
}
