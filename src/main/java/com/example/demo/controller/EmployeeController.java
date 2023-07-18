package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.IEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {
    private final IEmployeeService iEmployeeService;

    public EmployeeController(IEmployeeService iEmployeeService) {
        this.iEmployeeService = iEmployeeService;
    }

    @GetMapping("/")
    public String getAllEmployee(Model model) {
        List<Employee> employees = iEmployeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return "employee";
    }

    @PostMapping("/")
    public String addEmployee(@ModelAttribute Employee employee) {
            iEmployeeService.addEmployee(employee);
            return "redirect:/";
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") long id, @ModelAttribute Employee employee) {
        iEmployeeService.updateEmployee(id, employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") long id) {
        iEmployeeService.deleteEmployee(id);
        return "redirect:/";
    }
}