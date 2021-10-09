package com.internship.ems.service;

import com.internship.ems.dao.EmployeeRepository;
import com.internship.ems.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getById(int id) {
        return employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Employee updateEmployee(int id, Employee newEmployee) {
        Employee employee = employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());
        employee.setGender(newEmployee.getGender());
        employee.setAge(newEmployee.getAge());
        employee.setEmail(newEmployee.getEmail());
        employee.setDesignation(newEmployee.getDesignation());
        employee.setHireDate(newEmployee.getHireDate());
        employee.setResignedDate(newEmployee.getResignedDate());
        employee.setAddress(newEmployee.getAddress());
        employee.setDepartment(newEmployee.getDepartment());
        employeeRepository.save(employee);
        return employee;
    }

    public List<Employee> getAll() {
        List<Employee> result = new ArrayList<>();
        employeeRepository.findAll().forEach(result::add);
        return result;
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    public Employee findEmployeeByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email);
    }

    public List<Employee> getEmployeeByCustomQuery() {
        return employeeRepository.getEmployeeUsingCustomQuery();
    }

    public List<Employee> getEmployeeByJpql() {
        return employeeRepository.getEmployeeUsingJpql();
    }

    public  Employee getEmployeeByFirstNameAndLastName(String firstName,String lastName){
        return  employeeRepository.getEmployeeByFirstNameAndLastName(firstName,lastName);
    }

    public  Employee getEmployeeByFirstNameAndAge(String firstName, int age){
        return employeeRepository.getEmployeeByFirstNameAndAge(firstName,age);
    }

    public void updateEmployeeById(int employeeId,String firstName){
       employeeRepository.updateEmployeeById(employeeId,firstName);
        System.out.println("Updated using custom query");
    }

    public void deleteEmployeeById(int employeeId){
      employeeRepository.deleteEmployeeById(employeeId);
        System.out.println("Deleted using custom query");
    }
}

