package com.company.api.controller;

import com.company.api.model.Employee;
import com.company.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }

    @GetMapping("/Employees")
    public List<Employee> findAllEmployees(){
        return service.getEmployees();
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        return service.deleteEmployee(id);
    }
}
