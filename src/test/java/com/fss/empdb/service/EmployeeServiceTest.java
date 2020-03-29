package com.fss.empdb.service;

import com.fss.empdb.domain.Employee;
import com.fss.empdb.repos.EmployeeRepository;
import com.fss.empdb.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class EmployeeServiceTest {

    @Autowired
    EmployeeRepository employeeRepository;

    EmployeeService employeeService;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    private void setUp(){
        employeeService = new EmployeeService(employeeRepository);
    }

    private Employee testEmployee() throws Exception{
        Employee emp = new Employee();
        emp.setEmployeeSqid(1L);
        emp.setEmployeeId("10453");
        emp.setDepartmentId(1L);
        emp.setAccountId(1L);
        emp.setRegionId(1L);
        emp.setLocationId(1L);
        emp.setFirstName("Rama");
        emp.setMiddleName("Prabhu");
        emp.setLastName("Radhakrishnan");
        emp.setMobileNumber("12345");
        emp.setEmailId("rama@test.com");
        emp.setBillNoBill("Bill");
        emp.setDesignationId(1L);
        emp.setGrade("M4");
        emp.setPreviousExperience(0);
        emp.setInsUser(1L);
        emp.setLastUpdUser(1L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        emp.setJoiningDate(sdf.parse("2004-08-19"));
        emp.setInsDate(new Date());
        emp.setLastUpdDate(null);

        return emp;
    }

    @Test
    public void getAllEmployees_returnsEmployees() throws Exception{

        Employee emp = testEmployee();
        employeeService.createEmployee(emp);
        List<Employee> list = employeeService.getAllEmployees();
        System.out.println(list);
    }
}
