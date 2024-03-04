package com.vasy.resttemplate.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vasy.resttemplate.model.Employee;
import com.vasy.resttemplate.service.api.EmployeeService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/api/v1/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/id/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);
    }

    @DeleteMapping("/id/{id}")
    public String deleteEmployeeById(@PathVariable(name = "id") long id) {
        employeeService.deleteEmployeeById(id);
        return "Deleted";
    }

    @PutMapping("id/{id}")
    public Employee updatEmployee(@PathVariable(name = "id") long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

}
