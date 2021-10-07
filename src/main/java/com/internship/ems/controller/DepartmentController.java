package com.internship.ems.controller;

import com.internship.ems.model.Department;
import com.internship.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartment() {
        return departmentService.getAll();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable int id) {
        return departmentService.getById(id);
    }

    @PostMapping("/departments")
    public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department) {
        return new ResponseEntity<Department>(departmentService.save(department), HttpStatus.CREATED);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable int id, @Valid @RequestBody Department departmentInfo) {
        return new ResponseEntity<Department>(departmentService.updateDepartment(id, departmentInfo), HttpStatus.CREATED);
    }

    @DeleteMapping("/departments/{id}")
    public void removeDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
    }
}
