package com.example.springboot_6.repository;

import com.example.springboot_6.model.Department;
import com.example.springboot_6.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    
}