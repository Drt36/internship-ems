package com.internship.ems.controller;

import com.internship.ems.dto.DepartmentDto;
import com.internship.ems.mapper.DepartmentMapper;
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

    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping("/departments")
    public List<DepartmentDto> getAllDepartment() {
        return departmentMapper.modelsToDtos(departmentService.getAll());
    }

    @GetMapping("/departments/{id}")
    public DepartmentDto getDepartmentById(@PathVariable int id) {
        return departmentMapper.modelToDto(departmentService.getById(id));
    }

    @PostMapping("/departments")
    public ResponseEntity<DepartmentDto> saveDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        DepartmentDto departmentDtoSave = departmentMapper.modelToDto(departmentService.save(departmentMapper.dtoToModel(departmentDto)));
        return new ResponseEntity<DepartmentDto>(departmentDtoSave, HttpStatus.CREATED);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable int id, @Valid @RequestBody DepartmentDto departmentInfo) {
        DepartmentDto departmentDtoUpdate = departmentMapper.modelToDto(departmentService.updateDepartment(id, departmentMapper.dtoToModel(departmentInfo)));
        return new ResponseEntity<DepartmentDto>(departmentDtoUpdate, HttpStatus.CREATED);
    }

    @DeleteMapping("/departments/{id}")
    public void removeDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
    }
}
