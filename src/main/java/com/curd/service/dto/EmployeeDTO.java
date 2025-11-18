package com.curd.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(
        description = "EmployeeDTO model information"
)
public record EmployeeDTO(
        Long id,
        @Schema(description = "Employee Name")
        @NotEmpty(message = "Employee name should not be empty or null.")
        String name,
        @Schema(description = "Employee Email Id")
        @NotEmpty(message = "Employee email should not be empty or null.")
        @Email(message = "Employee email should be correct, please check and try again.")
        String emailAddress,
        @Schema(description = "Employee company Name")
        String company,
        @Schema(description = "Employee department Name")
        String department,
        @Schema(description = "Employee Phone Number")
        @NotEmpty(message = "Employee contact number should not be empty or null.")
        String phone,
        @Schema(description = "Employee Address")
        String address,
        @Schema(description = "Employee City Name")
        String city,
        @Schema(description = "Employee State Name")
        String state,
        @Schema(description = "Employee Country")
        @NotEmpty(message = "Employee country name should not be empty or null.")
        String country,
        @Schema(description = "Employee Postal Zipcode")
        @NotEmpty(message = "Employee zipcode should not be empty or null.")
        String zip,
        @Schema(description = "Employee Designation")
        String designation,
        @Schema(description = "Employee Salary")
        double salary,
        @Schema(description = "Employee Date of Joining")
        String dateOfJoining
       ) {}
