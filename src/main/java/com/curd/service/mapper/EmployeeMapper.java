package com.curd.service.mapper;

import com.curd.service.dto.EmployeeDTO;
import com.curd.service.entity.Employee;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Mapper
@Component
public class EmployeeMapper {
    public Employee dtoToEntity(EmployeeDTO dto) {
        if (dto == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(dto.id());
        employee.setName(dto.name());
        employee.setEmail(dto.emailAddress());
        employee.setCompany(dto.company());
        employee.setDepartment(dto.department());
        employee.setPhone(dto.phone());
        employee.setAddress(dto.address());
        employee.setCity(dto.city());
        employee.setState(dto.state());
        employee.setCountry(dto.country());
        employee.setZip(dto.zip());
        employee.setDesignation(dto.designation());
        employee.setSalary(dto.salary());
        employee.setDateOfJoining(Date.valueOf(dto.dateOfJoining()));
        return employee;
    }

    public EmployeeDTO entityToDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getCompany(),
                employee.getDepartment(),
                employee.getPhone(),
                employee.getAddress(),
                employee.getCity(),
                employee.getState(),
                employee.getCountry(),
                employee.getZip(),
                employee.getDesignation(),
                employee.getSalary(),
                employee.getDateOfJoining().toString()
        );
    }
}
