package com.curd.service.dto;

import jakarta.validation.constraints.*;

public record EmployeeDTO(
        Long id,
        @NotEmpty(message = "Employee name should not be empty or null.")
        String name,
        @NotEmpty(message = "Employee email should not be empty or null.")
        @Email(message = "Employee email should be correct, please check and try again.")
        String emailAddress,
        String company,
        String department,
        @NotEmpty(message = "Employee contact number should not be empty or null.")
        String phone,
        String address,
        String city,
        String state,
        @NotEmpty(message = "Employee country name should not be empty or null.")
        String country,
        @NotEmpty(message = "Employee zipcode should not be empty or null.")
        String zip,
        String designation,
        double salary,
        String dateOfJoining
       ) {}
