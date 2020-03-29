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

    public Employee(){
        /*
        default constructor
         */
    }

    @Column(name="EMPLOYEE_ID",nullable = false)
    String employeeId;

    @Column(name="DEPARTMENT_SQID",nullable = false)
   Long departmentId;

    @Column(name="ACCOUNT_ID",nullable = false)
    Long accountId;

    @Column(name="REGION_ID",nullable = false)
    Long regionId;

    @Column(name="LOCATION_ID",nullable = false)
    Long locationId;

   @Column(name="FIRST_NAME",nullable = false)
    String firstName;

 @Column(name="MIDDLE_NAME")
    String middleName;

 @Column(name="LAST_NAME",nullable = false)
    String lastName;

 @Column(name="MOBILE_NUM",nullable = false)
    String mobileNumber;

 @Column(name="EMAIL_ID",nullable = false)
    String emailId;

 @Column(name="GRADE",nullable = false)
    String grade;

 @Column(name="DESIGNATION_ID",nullable = false)
    Long designationId;

 @Column(name="REPORTING_MANAGER",nullable = false)
    String reportingManager;

 @Column(name="PREVIOUS_EXP",nullable = false)
    Integer previousExperience;

    @Temporal(TemporalType.DATE)
    @Column(name="JOINING_DATE",nullable = false)
    Date joiningDate;

 @Column(name="BILL_OR_NO_BILL",nullable = false)
    String billNoBill;

 @Column(name="PRIMARY_SKILL",nullable = false)
    Long primarySkillId;

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

    @Override
    public String toString() {
        return  "Employee[employeeId="
                + employeeId
                + ", firstName= "
                + firstName +", middleName= " + middleName + ", lastName= " + lastName
                + "]";
    }
}
