package com.internship.ems.controller;

import com.internship.ems.dto.EmployeeDto;
import com.internship.ems.model.Employee;
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

    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployee(){
        return employeeService.getAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getById(id);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.save(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@Valid @RequestBody Employee employeeInfo) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(id, employeeInfo), HttpStatus.CREATED);
    }

    @DeleteMapping("/employees/{id}")
    public void removeEmployee(@PathVariable int id){
        employeeService.deleteUser(id);
    }
}
