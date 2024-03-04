package com.vasy.resttemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vasy.resttemplate.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
