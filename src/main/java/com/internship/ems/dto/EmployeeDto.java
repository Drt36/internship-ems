package com.internship.ems.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.internship.ems.enums.Gender;
import com.internship.ems.model.Department;
import com.internship.ems.model.Salary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private int employeeId;

    @NotEmpty(message = "First Name Should not be empty!")
    @Size(max = 50, message = "Maximum length should be 50.")
    private String firstName;

    @NotEmpty(message = "Last Name should not be empty!")
    @Size(max = 50, message = "Maximum length should be 50.")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "Age should not be empty!")
    private int age;

    @Email
    @NotNull(message = "Email should not be empty!")
    @Size(max = 50, message = "Maximum length should be 50.")
    private String email;

    @Size(max = 50, message = "Maximum length should be 50.")
    private String designation;

    @NotNull(message = "Date should not be empty!")
    private Date hireDate;

    private Date resignedDate;

    @Size(max = 100, message = "Maximum length should be 100.")
    private String address;

    @JsonBackReference(value = "backrefrence-salary")
    private Salary salary;

    @JsonBackReference(value = "backrefrence-department")
    private Department department;


}
