package com.fss.empdb.service;

import com.fss.empdb.domain.Department;
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
import org.springframework.transaction.annotation.Transactional;

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
        Department dept = new Department();
        dept.setDepartmentId(1L);
        emp.setDepartment(dept);
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
        emp.setPrimarySkillId(1L);
        emp.setReportingManager("Balaji");
        emp.setInsUser(1L);
        emp.setLastUpdUser(1L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        emp.setJoiningDate(sdf.parse("2004-08-19"));
        emp.setInsDate(new Date());
        emp.setLastUpdDate(null);

        return emp;
    }

    @Test
    @Transactional
    public void createEmployee_success() throws Exception{
        //arrange
        Employee emp = testEmployee();

        //act
        employeeService.createEmployee(emp);

        //assert
        List<Employee> list = employeeService.getAllEmployees();
        System.out.println(list);
    }

    @Test
    @Transactional
    public void getAllEmployees_returnsEmployees() throws Exception{
        //arrange
        Employee emp = testEmployee();
        employeeService.createEmployee(emp);

        //act
        List<Employee> list = employeeService.getAllEmployees();

        //assert
        System.out.println(list);
    }

    @Test
    @Transactional
    public void getEmployeeById_returnsEmployee() throws Exception{
        //arrange
        Long employeeId = 1L;

        Employee emp = testEmployee();
        employeeService.createEmployee(emp);
        //act
        emp = employeeService.getEmployeeById(employeeId);

        //assert
        System.out.println(emp);
    }

    @Test
    @Transactional
    public void updateEmployee_success() throws Exception{
        //arrange
        Employee emp = testEmployee();
        employeeService.createEmployee(emp);

        //act
        emp.setFirstName("updated first name");
        Employee updatedEmp = employeeService.updateEmployee(emp);
        //assert
        System.out.println(updatedEmp.getFirstName());
    }

    @Test
    @Transactional
    public void deleteEmployee_success() throws Exception{
        //arrange
        Employee emp = testEmployee();
        employeeService.createEmployee(emp);

        //act
        employeeService.deleteEmployee(emp.getEmployeeSqid());
        //assert
        System.out.println("Employee Deleted.......");
    }
}
