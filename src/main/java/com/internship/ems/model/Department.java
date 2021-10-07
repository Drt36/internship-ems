package com.internship.ems.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "department",schema = "ems_db")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int department_id;

    @Column(length = 50,nullable = false)
    @Size(max=50,message = "Maximum length should be 50.")
    @NotEmpty(message = "Department name should not be empty!")
    private String name;

    @Column(length = 100)
    @Size(max=100,message = "Maximum length should be 100.")
    private String description;

}
