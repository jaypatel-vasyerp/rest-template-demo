package com.vasy.resttemplate.service.api;

import java.util.List;

import com.vasy.resttemplate.model.Employee;

public interface EmployeeService {

    Employee getEmployeeById(long id);

    Employee addNewEmployee(Employee employee);

    void deleteEmployeeById(long id);

    List<Employee> getAllEmployees();

    Employee updateEmployee(long id, Employee employee);

}
