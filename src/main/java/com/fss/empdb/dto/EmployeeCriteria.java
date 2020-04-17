package com.fss.empdb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeCriteria {

    String employeeId;
    String employeeName;

    @Override
    public String toString() {
        return "EmployeeCriteria{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}
