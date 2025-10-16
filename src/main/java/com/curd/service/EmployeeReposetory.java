package com.curd.service;

import com.curd.service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeReposetory extends JpaRepository<Employee, Long> {
}
