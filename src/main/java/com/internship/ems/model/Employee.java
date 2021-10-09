package com.internship.ems.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.internship.ems.enums.Gender;
import com.internship.ems.listener.EmployeeListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "employee", schema = "ems_db")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(EmployeeListener.class)
@NamedQuery(name = "Employee.getEmployeeByNamedQuery", query = "select e from Employee e where e.department.departmentId=:id")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(nullable = false, length = 50)
    @NotEmpty(message = "First Name Should not be empty!")
    @Size(max = 50, message = "Maximum length should be 50.")
    private String firstName;

    @Column(nullable = false, length = 50)
    @NotEmpty(message = "Last Name should not be empty!")
    @Size(max = 50, message = "Maximum length should be 50.")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 6)
    private Gender gender;

    @NotNull(message = "Age should not be empty!")
    private int age;

    @Email
    @NotNull(message = "Email should not be empty!")
    @Column(unique = true, nullable = false, length = 50)
    @Size(max = 50, message = "Maximum length should be 50.")
    private String email;

    @Size(max = 50, message = "Maximum length should be 50.")
    @Column(columnDefinition = "varchar(50) default 'Manager'")
    private String designation;

    @NotNull(message = "Date should not be empty!")
    private Date hireDate;

    private Date resignedDate;

    @Column(length = 100)
    @Size(max = 100, message = "Maximum length should be 100.")
    private String address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salary_id", unique = true)
    @JsonBackReference(value = "backrefrence-salary")
    private Salary salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @JsonBackReference(value = "backrefrence-department")
    private Department department;

}