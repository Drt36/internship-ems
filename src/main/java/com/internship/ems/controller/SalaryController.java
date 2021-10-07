package com.internship.ems.controller;

import com.internship.ems.model.Salary;
import com.internship.ems.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Salary> saveSalary(@Valid @RequestBody Salary salary) {
        return new ResponseEntity<Salary>(salaryService.save(salary), HttpStatus.CREATED);
    }

    @PutMapping("/salary/{id}")
    public ResponseEntity<Salary> updateSalary(@PathVariable int id, @Valid @RequestBody Salary salaryInfo) {
        return new ResponseEntity<Salary>(salaryService.updateSalary(id, salaryInfo), HttpStatus.CREATED);
    }

    @DeleteMapping("/salary/{id}")
    public void removeSalary(@PathVariable int id) {
        salaryService.deleteSalary(id);
    }
}
