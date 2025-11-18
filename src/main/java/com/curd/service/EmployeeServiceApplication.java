package com.curd.service;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
      info = @Info(
              title = "Employee API Documentation",
              description = "Employee API Documentation",
              version = "v1.0",
              contact = @Contact(
                      name = "Sushil Kumar Singh",
                      email = "sushil@gmail.com",
                      url = "https://www.sushil.com"
              ),
              license = @License(
                      name = "Apache 2.0",
                      url = "https://www.sushil.com/license"
              )
      ),
      externalDocs = @ExternalDocumentation(
              description = "Spring boot Employee management API",
              url = "https://www.sushil.com/employee.html"
      )
)
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
