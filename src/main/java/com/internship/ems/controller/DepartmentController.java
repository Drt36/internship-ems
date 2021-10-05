package com.internship.ems.controller;

import com.internship.ems.model.Department;
import com.internship.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Department saveDepartment(@Valid @RequestBody Department department) {
        return departmentService.save(department);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable int id, @RequestBody Department departmentInfo) {
        return departmentService.updateDepartment(id, departmentInfo);
    }

    @DeleteMapping("/departments/{id}")
    public void removeDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
    }
}
