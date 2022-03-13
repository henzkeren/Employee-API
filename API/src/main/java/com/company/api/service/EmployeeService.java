package com.company.api.service;

import com.company.api.model.Employee;
import com.company.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee addEmployee(Employee employee){

        employee.setId(customId());
        return repository.save(employee);
    }

    public List<Employee> getEmployees(){
        return repository.findAll();
    }

    public Employee getEmployeeById(int id){
        return repository.findById(id).orElse(null);
    }

    public Employee getEmployeeByName(String name){
        return repository.findByName(name);
    }

    public String deleteEmployee(int id){
        repository.deleteById(id);
        return "Employee Removed!" + id;
    }

    public Employee updateEmployee(Employee employee){
        Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setGrade(employee.getGrade());
        return repository.save(existingEmployee);
    }

    public int customId(){
        String customIdGenerate = null;
        int customIdInt = 0;
        Employee employee = new Employee();
        if (getEmployees().isEmpty()){
            customIdGenerate = "10001";
            customIdInt = Integer.parseInt(customIdGenerate);
        }else if (!getEmployees().isEmpty()){
            customIdGenerate = String.valueOf(repository.findAll().size());
            customIdInt = 10001 + Integer.parseInt(customIdGenerate);;
        }
        return customIdInt;
    }

}
