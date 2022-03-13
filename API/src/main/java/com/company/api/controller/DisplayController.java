package com.company.api.controller;

import com.company.api.model.Employee;
import com.company.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DisplayController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", service.getEmployees());
        return "index";
    }
    @GetMapping("/viewAddEmployee")
    public String viewAddEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("addViewEmployees", employee);
        return "add";
    }
    @GetMapping("/viewUpdateEmployee/{id}")
    public String viewUpdateEmployee(@PathVariable(value="id") int id, Model model){
        Employee employee = service.getEmployeeById(id);
        model.addAttribute("updateEmployees", employee);
        return "update";
    }
    @PostMapping("/submitDataEmployee")
    public String submitDataEmployee(Employee employee){
        service.addEmployee(employee);
        return "redirect:/";
    }
    @PostMapping("/updateDataEmployee")
    public String updateDataEmployee(Employee employee){
        service.updateEmployee(employee);
        return "redirect:/";
    }
}
