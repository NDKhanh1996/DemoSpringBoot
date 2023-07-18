package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employee != null) {
            employeeRepository.save(employee);
        }
    }

    @Override
    public void updateEmployee(long id, Employee employee) {
        if (employee != null) {
            Employee employee1 = employeeRepository.getReferenceById(id);
            employee1.setName(employee.getName());
            employee1.setAddress(employee.getAddress());

            employeeRepository.save(employee1);
        }
    }

    @Override
    public void deleteEmployee(long id) {
        if (id >= 1) {
            Employee employee = employeeRepository.getReferenceById(id);
            employeeRepository.delete(employee);
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getOneEmployee(long id) {
        return employeeRepository.getReferenceById(id);
    }
}