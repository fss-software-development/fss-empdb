package com.fss.empdb.service;

import com.fss.empdb.domain.Employee;
import com.fss.empdb.exception.ResourceNotFoundException;
import com.fss.empdb.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
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
