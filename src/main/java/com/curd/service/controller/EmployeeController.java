package com.curd.service.controller;

import com.curd.service.dto.EmployeeDTO;
import com.curd.service.exception.ErrorDetails;
import com.curd.service.exception.ResourceNotFoundException;
import com.curd.service.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/api/employees")
@Tag(
        name = "CURD Rest APIs for Employee operations",
        description = "CURD Rest APIs- Create Employee, Update Employee, GetAllEmployee, GetEmployeeById, DeleteEmployee"
)
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(
            summary = "Create Employee REST API",
            description = "Create Employee REST API is used to save Employee in DB"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/")
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeService.createEmployee(employeeDTO));
    }

    @Operation(
            summary = "GET ALL Employees REST API",
            description = "GET Employees REST API is used to GET Employees from the DB"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employeeService.getAllEmployees());
    }

    @Operation(
            summary = "GET ONE Employee REST API",
            description = "GET Employee REST API is used to GET Employee from the DB by ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(employeeService.getEmployeeById(id));
    }

    @Operation(
            summary = "Update Employee REST API",
            description = "Update Employee REST API is used to update Employee in DB"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employeeService.updateEmployee(id, employeeDTO));
    }

    @Operation(
            summary = "Delete Employee REST API",
            description = "Delete Employee REST API is used to DELETE Employee from the DB by ID."
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 SUCCESS"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Class lavel handler for exception can be added here
   /* @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest webRequest) {
        ErrorDetails errorDetails =
                new ErrorDetails(
                        LocalDateTime.now(),
                        ex.getMessage(),
                        webRequest.getDescription(false),
                        "USER_NOT_FOUND");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }*/

}
