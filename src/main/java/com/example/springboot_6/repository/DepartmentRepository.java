package com.example.springboot_6.repository;

import com.example.springboot_6.model.Department;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer>{
    
}