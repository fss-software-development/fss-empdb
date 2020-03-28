package com.fss.empdb.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Employee {
    @Id
            @Column(name="EMPLOYEE_SQID")
    Long employeeSqid;

    public Employee(){}

    @Column(name="EMPLOYEE_ID")
    String employeeId;

    @Column(name="DEPARTMENT_SQID")
   Long departmentId;

    @Column(name="ACCOUNT_ID")
    Long accountId;

    @Column(name="REGION_ID")
    Long regionId;

    @Column(name="LOCATION_ID")
    Long locationId;

   @Column(name="FIRST_NAME")
    String firstName;

 @Column(name="MIDDLE_NAME")
    String middleName;

 @Column(name="LAST_NAME")
    String lastName;

 @Column(name="MOBILE_NUM")
    String mobileNumber;

 @Column(name="EMAIL_ID")
    String emailId;

 @Column(name="GRADE")
    String grade;

 @Column(name="DESIGNATION_ID")
    Long designationId;

 @Column(name="REPORTING_MANAGER")
    String reportingManager;

 @Column(name="PREVIOUS_EXP")
    Integer previousExperience;

    @Temporal(TemporalType.DATE)
    @Column(name="JOINING_DATE")
    Date joiningDate;

 @Column(name="BILL_OR_NO_BILL")
    String billNoBill;

 @Column(name="PRIMARY_SKILL")
    Long primarySkillId;

 @Column(name="INS_USER")
    Long insUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="INS_DATE")
    Date insDate;

 @Column(name="LAST_UPDATE_USER")
    Long lastUpdUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LAST_UPDATE_DATE")
    Date lastUpdDate;

}
