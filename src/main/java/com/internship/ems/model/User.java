package com.internship.ems.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user",schema = "ems_db")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Username should not be empty!")
    @Size(max = 20, message = "Maximum length should be 20.")
    @Column(unique = true, nullable = false, length = 20)
    private String username;

    @NotEmpty(message = "Password should not be empty!")
    @Size(max = 20, min = 8, message = "Maximum length should be between 8 to 50.")
    @Column(nullable = false, length = 20)
    private String password;
}
