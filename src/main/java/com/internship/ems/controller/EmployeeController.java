package com.internship.ems.controller;

import com.internship.ems.dto.EmployeeDto;
import com.internship.ems.mapper.EmployeeMapper;
import com.internship.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployee(){
        return employeeMapper.modelsToDtos(employeeService.getAll());
    }

    @GetMapping("/employees/{id}")
    public EmployeeDto getEmployeeById(@PathVariable int id){
        return employeeMapper.modelToDto(employeeService.getById(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDtoSave=employeeMapper.modelToDto(employeeService.save(employeeMapper.dtoToModel(employeeDto)));
        return new ResponseEntity<EmployeeDto>( employeeDtoSave,HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable int id,@Valid @RequestBody EmployeeDto employeeInfo) {
        EmployeeDto employeeDtoUpdate=employeeMapper.modelToDto(employeeService.updateEmployee(id,employeeMapper.dtoToModel(employeeInfo)));
        return new ResponseEntity<EmployeeDto>(employeeDtoUpdate,HttpStatus.CREATED);
    }

    @DeleteMapping("/employees/{id}")
    public void removeEmployee(@PathVariable int id){
        employeeService.deleteUser(id);
    }
}
