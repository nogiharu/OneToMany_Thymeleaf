package com.example.springboot_6.repository;

import com.example.springboot_6.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer>{
    
}