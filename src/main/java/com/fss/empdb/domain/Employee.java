package com.fss.empdb.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
@XmlRootElement
@EqualsAndHashCode

public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_SQID")
    Long employeeSqId;

    @Column(name = "EMPLOYEE_ID")
    Long employeeId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "REGION_ID")
    private Region region;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    @Column(name = "EMPLOYEE_NAME", nullable = false)
    String employeeName;

    @Column(name = "MOBILE_NUM", nullable = false)
    Long mobileNum;

    @Column(name = "EMAIL_ID", nullable = false)
    String emailId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "GRADE_ID")
    private Grade grade;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "DESIGNATION_ID")
    private Designation designation;

    @Column(name = "REPORTING_MANAGER", nullable = false)
    String reportingManager;

    @Column(name = "PREVIOUS_EXP", nullable = false)
    Long previousExp;

    @Temporal(TemporalType.DATE)
    @Column(name = "JOINING_DATE", nullable = false)
    Date joiningDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "BILLABLE_STATUS_ID")
    private BillableStatus billableStatus;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "SERVICE_LINE_ID")
    private ServiceLine serviceLine;

    @Column(name = "ACTIVITY_NAME", nullable = false)
    String activityName;

    @Column(name = "EXPERIENCE_GAPS", nullable = false)
    Long experienceGaps;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ACADEMICS_ID")
    private Academics academics;

    @Column(name = "INS_USER",nullable = true)
    private Long insUser;

    @Temporal(TemporalType.DATE)
    @Column(name = "INS_DATE",nullable = true)
    private Date insDate;

    @Column(name = "LAST_UPDATE_USER",nullable = true)
    private Long lastUpdateUser;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_UPDATE_DATE",nullable = true)
    private Date lastUpdateDate;

    @JsonIgnore
    @Column(name="PRIMARY_SKILL")
    Long primarySkillId;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeSqId=" + employeeSqId +
                ", employeeId=" + employeeId +
                ", department=" + department +
                ", account=" + account +
                ", region=" + region +
                ", location=" + location +
                ", employeeName='" + employeeName + '\'' +
                ", mobileNum=" + mobileNum +
                ", emailId='" + emailId + '\'' +
                ", grade=" + grade +
                ", designation=" + designation +
                ", reportingManager='" + reportingManager + '\'' +
                ", previousExp=" + previousExp +
                ", joiningDate=" + joiningDate +
                ", billableStatus=" + billableStatus +
                ", serviceLine=" + serviceLine +
                ", activityName='" + activityName + '\'' +
                ", experienceGaps=" + experienceGaps +
                ", academics=" + academics +
                ", insUser=" + insUser +
                ", insDate=" + insDate +
                ", lastUpdateUser=" + lastUpdateUser +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }

}
