package com.internship.ems.controller;

import com.internship.ems.dto.EmployeeDto;
import com.internship.ems.mapper.EmployeeMapper;
import com.internship.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployee() {
        return employeeMapper.modelsToDtos(employeeService.getAll());
    }

    @GetMapping("/employees/{id}")
    public EmployeeDto getEmployeeById(@PathVariable int id) {
        return employeeMapper.modelToDto(employeeService.getById(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        EmployeeDto employeeDtoSave = employeeMapper.modelToDto(employeeService.save(employeeMapper.dtoToModel(employeeDto)));
        return new ResponseEntity<EmployeeDto>(employeeDtoSave, HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeeDto employeeInfo) {
        EmployeeDto employeeDtoUpdate = employeeMapper.modelToDto(employeeService.updateEmployee(id, employeeMapper.dtoToModel(employeeInfo)));
        return new ResponseEntity<EmployeeDto>(employeeDtoUpdate, HttpStatus.CREATED);
    }

    @DeleteMapping("/employees/{id}")
    public void removeEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/custom/employees/query")
    public List<EmployeeDto> getEmployeeByQuery() {
        return employeeMapper.modelsToDtos(employeeService.getEmployeeByCustomQuery());
    }

    @GetMapping("/custom/employees/jpql")
    public List<EmployeeDto> getEmployeeByJpql() {
        return employeeMapper.modelsToDtos(employeeService.getEmployeeByJpql());
    }

    @Transactional
    @PutMapping("/custom/employees/{id}")
    public void updateEmployee(@PathVariable int id,@RequestParam("firstName") String firstName) {
         employeeService.updateEmployeeById(id, firstName);
    }

    @Transactional
    @DeleteMapping("/custom/employees/{id}")
    public void removeEmployeeById(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
    }

}
