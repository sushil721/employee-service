package com.curd.service.mapper;

import com.curd.service.dto.EmployeeDTO;
import com.curd.service.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.sql.Date;

@Mapper
public interface AutoEmployeeMapper {

    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

    @Mapping(source = "emailAddress", target = "email")
    @Mapping(source = "dateOfJoining", target = "dateOfJoining", qualifiedByName = "stringToSqlDate")
    Employee dtoToEntity(EmployeeDTO dto);

    @Mapping(source = "email", target = "emailAddress")
    @Mapping(source = "dateOfJoining", target = "dateOfJoining", qualifiedByName = "sqlDateToString")
    EmployeeDTO entityToDto(Employee employee);


    @Named("stringToSqlDate")
    static Date stringToSqlDate(String date) {
        return date == null ? null : Date.valueOf(date);
    }

    @Named("sqlDateToString")
    static String sqlDateToString(Date date) {
        return date == null ? null : date.toString();
    }
}
