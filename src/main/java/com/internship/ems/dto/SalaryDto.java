package com.internship.ems.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.internship.ems.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryDto {
    private int salaryId;

    @NotNull(message = "Issue date should not be empty!")
    private Date issueDate;

    @NotNull(message = "Amount date should not be empty!")
    private float amount;

    private float bonus;

    private Employee employee;
}
