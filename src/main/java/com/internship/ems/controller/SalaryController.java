package com.internship.ems.controller;

import com.internship.ems.model.Salary;
import com.internship.ems.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @GetMapping("/salary")
    public List<Salary> getAllSalary() {
        return salaryService.getAll();
    }

    @GetMapping("/salary/{id}")
    public Salary getSalaryById(@PathVariable int id) {
        return salaryService.getById(id);
    }

    @PostMapping("/salary")
    public Salary saveSalary(@Valid @RequestBody Salary salary) {
        return salaryService.save(salary);
    }

    @PutMapping("/salary/{id}")
    public Salary updateSalary(@PathVariable int id, @RequestBody Salary salaryInfo) {
        return salaryService.updateSalary(id, salaryInfo);
    }

    @DeleteMapping("/salary/{id}")
    public void removeSalary(@PathVariable int id) {
        salaryService.deleteSalary(id);
    }
}
