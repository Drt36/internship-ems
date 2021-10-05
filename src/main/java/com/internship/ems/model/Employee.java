package com.internship.ems.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;

    @NotEmpty
    @Size(max=50)
    private String firstName;

    @NotEmpty
    @Size(max=50)
    private String lastName;

    @NotEmpty
    @Size(max=6)
    private String gender;

    @NotEmpty
    private int age;

    @Email
    @NotEmpty
    @Size(max=50)
    private String email;

    @NotEmpty
    @Size(max=50)
    private String designation;

    @NotEmpty
    private Date hireDate;

    private Date resignedDate;

    @Size(max =100)
    private String address;

}
