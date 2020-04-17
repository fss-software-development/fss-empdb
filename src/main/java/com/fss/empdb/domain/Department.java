package com.fss.empdb.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "department")
@XmlRootElement
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "departmentId")
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DEPARTMENT_ID")
    Long departmentId;

    public Department() {

    }

    @Column(name = "DEPARTMENT_NAME", nullable = false)
    String departmentName;

    @Column(name = "DEPARTMENT_HEAD", nullable = false)
    String departmentHead;

    @Column(name = "INS_USER", nullable = false)
    Long insUser;

    @JsonIgnore
    @Temporal(TemporalType.DATE)
    @Column(name = "INS_DATE", nullable = false)
    Date insDate;

    @JsonIgnore
    @Column(name = "LAST_UPDATE_USER", nullable = false)
    Long lastUpdateUser;

    @JsonIgnore
    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_UPDATE_DATE", nullable = false)
    Date lastUpdateDate;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Employee> employees;

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentHead='" + departmentHead + '\'' +
                ", insUser=" + insUser +
                ", insDate=" + insDate +
                ", lastUpdateUser=" + lastUpdateUser +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }

}