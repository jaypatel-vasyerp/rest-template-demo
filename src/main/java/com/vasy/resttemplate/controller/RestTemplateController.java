package com.vasy.resttemplate.controller;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vasy.resttemplate.model.Employee;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v2/employee")
@AllArgsConstructor
public class RestTemplateController {

    private final String API_URL = "http://localhost:8080/api/v1/employee";

    private final RestTemplate restTemplate;

    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id") long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(API_URL + "/id/" + id, HttpMethod.GET, entity, Employee.class);
    }

    @GetMapping("")
    public ResponseEntity getAllEmployees() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(API_URL, HttpMethod.GET, entity, Employee[].class);
    }

    @PostMapping("")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<>(employee, httpHeaders);
        return restTemplate.exchange(API_URL, HttpMethod.POST, entity, Employee.class);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable(name = "id") long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(API_URL, HttpMethod.DELETE, entity, String.class);
    }

    @PutMapping("id/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<>(employee, httpHeaders);
        return restTemplate.exchange(API_URL, HttpMethod.PUT, entity, Employee.class);
    }

}
