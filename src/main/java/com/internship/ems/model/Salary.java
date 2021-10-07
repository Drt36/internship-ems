package com.internship.ems.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "salary",schema = "ems_db")
@Data
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salary_id;

    @Column(nullable = false)
    @NotNull(message = "Issue date should not be empty!")
    private Date issueDate;

    @Column(nullable = false)
    @NotNull(message = "Amount date should not be empty!")
    private float amount;

    private float bonus;
}
