package com.fss.empdb.service;

import com.fss.empdb.domain.Employee;
import com.fss.empdb.exception.ResourceNotFoundException;
import com.fss.empdb.repos.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Log4j2
@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        MDC.put("MDCTest", "MDC-Id " + new Random().nextInt());
        log.debug("Getting all employees");
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
    }

    public Employee updateEmployee(Employee employee){
        employeeRepository.findById(employee.getEmployeeSqid())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: "
                        + employee.getEmployeeSqid()));


       return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
    }
}
