package com.vasy.resttemplate.service.api.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vasy.resttemplate.exception.EntityNotFoundException;
import com.vasy.resttemplate.model.Employee;
import com.vasy.resttemplate.repository.EmployeeRepository;
import com.vasy.resttemplate.service.api.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with id " + id + " not exists."));
                

        return employee;
    }

    @Override
    public Employee addNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        Employee updatedEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with id " + id + " not exists."));
        if (employee.getName() != null && !employee.getName().isEmpty()) {
            updatedEmployee.setName(employee.getName());
        }
        updatedEmployee.setSalary(employee.getSalary());
        return employeeRepository.save(updatedEmployee);
    }

}
