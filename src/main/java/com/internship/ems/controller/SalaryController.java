package com.internship.ems.controller;

import com.internship.ems.dto.SalaryDto;
import com.internship.ems.mapper.SalaryMapper;
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
    private  SalaryService salaryService;

    @Autowired
    private SalaryMapper salaryMapper;

    @GetMapping("/salary")
    public List<SalaryDto> getAllSalary() {
        return salaryMapper.modelsToDtos(salaryService.getAll());
    }

    @GetMapping("/salary/{id}")
    public SalaryDto getSalaryById(@PathVariable int id) {
        return salaryMapper.modelToDto(salaryService.getById(id));
    }

    @PostMapping("/salary")
    public ResponseEntity<SalaryDto> saveSalary(@Valid @RequestBody SalaryDto salaryDto) {
        SalaryDto salaryDtoSave=salaryMapper.modelToDto(salaryService.save(salaryMapper.dtoToModel(salaryDto)));
        return new ResponseEntity<SalaryDto>(salaryDtoSave, HttpStatus.CREATED);
    }

    @PutMapping("/salary/{id}")
    public ResponseEntity<SalaryDto> updateSalary(@PathVariable int id, @Valid @RequestBody SalaryDto salaryInfo) {
        SalaryDto salaryDtoUpdate=salaryMapper.modelToDto(salaryService.updateSalary(id, salaryMapper.dtoToModel(salaryInfo)));
        return new ResponseEntity<SalaryDto>(salaryDtoUpdate, HttpStatus.CREATED);
    }

    @DeleteMapping("/salary/{id}")
    public void removeSalary(@PathVariable int id) {
        salaryService.deleteSalary(id);
    }
}
