package com.internship.ems.service;

import com.internship.ems.dao.DepartmentRepository;
import com.internship.ems.dao.EmployeeRepository;
import com.internship.ems.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public Department getById(int id) {
        return departmentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Department updateDepartment(int id, Department newDepartment) {
        Department department = departmentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        department.setName(newDepartment.getName());
        department.setDescription(newDepartment.getDescription());
        departmentRepository.save(department);
        return department;
    }

    public List<Department> getAll() {
        List<Department> result = new ArrayList<>();
        departmentRepository.findAll().forEach(result::add);
        return result;
    }

    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }
}
