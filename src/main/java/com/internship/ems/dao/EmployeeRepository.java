package com.internship.ems.dao;

import com.internship.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findEmployeeByEmail(String email);

    Boolean existsEmployeeByEmail(String email);

    @Query(value = "select * from employee", nativeQuery = true)
    List<Employee> getEmployeeUsingCustomQuery();

    @Query("select e from Employee e")
    List<Employee> getEmployeeUsingJpql();

    @Query("select e from Employee e where e.firstName=?1 and  e.lastName=?2")
    Employee getEmployeeByFirstNameAndLastName(String firstName, String lastName);

    @Query("select e from Employee e where e.firstName=:firstName and e.age=:age")
    List<Employee> getEmployeeByFirstNameAndAge(@Param("firstName") String firstName, @Param("age") int age);

    @Modifying
    @Query("update Employee e set e.firstName=:firstName where e.employeeId=:employeeId")
    void updateEmployeeById(@Param("employeeId") int employeeId, @Param("firstName") String firstName);

    @Modifying
    @Query("delete from Employee e where e.employeeId=:employeeId")
    void deleteEmployeeById(@Param("employeeId") int employeeId);
}
