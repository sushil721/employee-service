package com.curd.service.dto;

public record EmployeeDTO(
        Long id,
        String name,
        String email,
        String company,
        String department,
        String phone,
        String address,
        String city,
        String state,
        String country,
        String zip,
        String designation,
        double salary,
        String dateOfJoining
       ) {}
