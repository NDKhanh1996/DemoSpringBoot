package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public void addEmployee(Employee employee);

    public void updateEmployee(long id, Employee employee);

    public void deleteEmployee(long id);

    public List<Employee> getAllEmployee();

    public Employee getOneEmployee(long id);
}