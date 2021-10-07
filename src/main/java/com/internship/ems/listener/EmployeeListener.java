package com.internship.ems.listener;

import com.internship.ems.model.Employee;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;

public class EmployeeListener {
    private static Log log = LogFactory.getLog(EmployeeListener.class);

    @PrePersist
    private void beforePost(Employee employee) {
        log.info("On processing to add an employee");
    }

    @PreUpdate
    private void beforeUpdate(Employee employee) {
        log.info("On processing to update employee: " + employee.getEmployee_id());
    }

    @PreRemove
    private void beforeRemove(Employee employee) {
        log.info("On processing to delete employee: " + employee.getEmployee_id());
    }

    @PostPersist
    private void afterPost(Employee employee) {
        log.info("Add process completed for employee: " + employee.getEmployee_id());
    }

    @PostUpdate
    private void afterUpdate(Employee employee) {
        log.info("Update process completed for employee: " + employee.getEmployee_id());
    }

    @PostRemove
    private void afterRemove(Employee employee) {
        log.info("Delete process completed for employee: " + employee.getEmployee_id());
    }

    @PostLoad
    private void afterLoad(Employee employee) {
        log.info("Employee loaded from database: " + employee.getEmployee_id());
    }
}