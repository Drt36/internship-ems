package com.internship.ems.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.internship.ems.listener.DepartmentListener;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "department", schema = "ems_db")
@Data
@EntityListeners(DepartmentListener.class)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Column(length = 50, nullable = false)
    @Size(max = 50, message = "Maximum length should be 50.")
    @NotEmpty(message = "Department name should not be empty!")
    private String name;

    @Column(length = 100)
    @Size(max = 100, message = "Maximum length should be 100.")
    private String description;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "backrefrence-department")
    private List<Employee> employees;
}
