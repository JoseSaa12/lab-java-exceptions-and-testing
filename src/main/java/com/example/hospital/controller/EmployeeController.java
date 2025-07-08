package com.example.hospital.controller;

import com.example.hospital.model.Employee;
import com.example.hospital.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/status/{status}")
    public List<Employee> getByStatus(@PathVariable Employee.Status status) {
        return repository.findByStatus(status);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getByDepartment(@PathVariable String department) {
        return repository.findByDepartment(department);
    }
}
