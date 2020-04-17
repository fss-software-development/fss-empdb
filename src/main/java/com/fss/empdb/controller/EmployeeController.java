package com.fss.empdb.controller;

import com.fss.empdb.domain.Employee;
import com.fss.empdb.domain.SearchCriteria;
import com.fss.empdb.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fss.empdb.dto.EmployeeCriteria;
import com.fss.empdb.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@CrossOrigin()
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private static Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    //Get All Employee
    @GetMapping("/get-all-employee")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    //Get Employee Details By Id - View Case
    @GetMapping("/get-all-employee/{id}")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    //Get Employees By Search Criteria
    @PostMapping(value = "/emp-search-criteria", produces = "application/json")
    public ResponseEntity<List<Employee>> getEmployeeBySearchCriteria1(@RequestBody SearchCriteria empSearch) {
        return ResponseEntity.ok().body(employeeService.findByEmp(empSearch));
    }

    //Add & Update Employee
    @PostMapping(value = "/emp-add-update")
    public ResponseEntity<Employee> createOrUpdateEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.createOrUpdateEmployee(employee);
        return new ResponseEntity<Employee>(emp, new HttpHeaders(), HttpStatus.OK);
    }

    //Delete Employee
    @DeleteMapping("/emp-delete/{id}")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        return ResponseEntity.ok().body(employeeService.createEmployee(employee));
    }


}
