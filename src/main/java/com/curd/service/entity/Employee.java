package com.curd.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String company;
    private String department;
    @Column(unique = true)
    private String phone;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String designation;
    private double salary;
    private Date dateOfJoining;
}

