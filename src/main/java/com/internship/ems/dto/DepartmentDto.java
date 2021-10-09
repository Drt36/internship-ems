package com.internship.ems.dto;

import com.internship.ems.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private int departmentId;

    @Size(max = 50, message = "Maximum length should be 50.")
    @NotEmpty(message = "Department name should not be empty!")
    private String name;

    @Size(max = 100, message = "Maximum length should be 100.")
    private String description;

    private List<Employee> employees;
}
