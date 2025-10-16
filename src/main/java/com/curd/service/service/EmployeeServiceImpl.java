package com.curd.service.service;

import com.curd.service.EmployeeReposetory;
import com.curd.service.dto.EmployeeDTO;
import com.curd.service.entity.Employee;
import com.curd.service.exception.EmployeeNotFoundException;
import com.curd.service.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeReposetory employeeReposetory;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeReposetory employeeReposetory, EmployeeMapper employeeMapper) {
        this.employeeReposetory = employeeReposetory;
        this.employeeMapper = employeeMapper;
    }


    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        if(employeeDTO == null){
            return null;
        }
        Employee employee = employeeMapper.dtoToEntity(employeeDTO);
        Employee savedEmployee = employeeReposetory.save(employee);//.orElseThrow(() -> new EmployeeNotFoundException("Failed to save employee"));
        return employeeMapper.entityToDto(savedEmployee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeReposetory
                .findAll()
                .stream()
                .map(employeeMapper::entityToDto)
                .collect(toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return employeeReposetory.findById(id)
                .map(employeeMapper::entityToDto)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeReposetory.findById(id)
                                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        employee.setAddress(employeeDTO.address() != null ? employeeDTO.address() : employee.getAddress());
        employee.setName(employeeDTO.name() != null ? employeeDTO.name() : employee.getName());
        employee.setEmail(employeeDTO.email() != null ? employeeDTO.email() : employee.getEmail());
        employee.setCompany(employeeDTO.company() != null ? employeeDTO.company() : employee.getCompany());
        employee.setDepartment(employeeDTO.department() != null ? employeeDTO.department() : employee.getDepartment());
        employee.setPhone(employeeDTO.phone() != null ? employeeDTO.phone() : employee.getPhone());
        employee.setCity(employeeDTO.city() != null ? employeeDTO.city() : employee.getCity());
        employee.setState(employeeDTO.state() != null ? employeeDTO.state() : employee.getState());
        employee.setCountry(employeeDTO.country() != null ? employeeDTO.country() : employee.getCountry());
        employee.setZip(employeeDTO.zip() != null ? employeeDTO.zip() : employee.getZip());
        employee.setDesignation(employeeDTO.designation() != null ? employeeDTO.designation() : employee.getDesignation());
        employee.setSalary(employeeDTO.salary() != 0.0 ? employeeDTO.salary() : employee.getSalary());
        employee.setDateOfJoining(employeeDTO.dateOfJoining() != null ? Date.valueOf(employeeDTO.dateOfJoining()) : employee.getDateOfJoining());
        Employee updatedEmployee = employeeReposetory.save(employee);
        return employeeMapper.entityToDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeReposetory.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        employeeReposetory.delete(employee);
    }
}
