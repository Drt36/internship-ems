package com.internship.ems.mapper;

import com.internship.ems.dto.EmployeeDto;
import com.internship.ems.model.Employee;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper EMPLOYEE_MAPPER= Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto modelToDto(Employee employee);

    List<EmployeeDto> modelsToDtos(List<Employee> employees);

    @InheritInverseConfiguration
    Employee dtoToModel(EmployeeDto employeeDto);

}
