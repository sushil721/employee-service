package com.curd.service.repository;

import com.curd.service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeReposetory extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
}
