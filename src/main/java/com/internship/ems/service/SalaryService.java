package com.internship.ems.service;

import com.internship.ems.dao.SalaryRepository;
import com.internship.ems.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;

    public Salary save(Salary salary) {
        return salaryRepository.save(salary);
    }

    public Salary getById(int id) {
        return salaryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Salary updateSalary(int id, Salary newSalary) {
        Salary salary = salaryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        salary.setIssueDate(newSalary.getIssueDate());
        salary.setAmount(newSalary.getAmount());
        salary.setBonus(newSalary.getBonus());
        salaryRepository.save(salary);
        return salary;
    }

    public List<Salary> getAll() {
        List<Salary> result = new ArrayList<>();
        salaryRepository.findAll().forEach(result::add);
        return result;
    }

    public void deleteSalary(int id) {
        salaryRepository.deleteById(id);
    }
}
