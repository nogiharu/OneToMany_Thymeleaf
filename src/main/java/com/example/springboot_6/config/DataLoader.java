package com.example.springboot_6.config;

/* import com.example.springboot_6.repository.DepartmentRepository;
import com.example.springboot_6.repository.EmployeeRepository;
 */
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner{
    /* private final EmployeeRepository repository;
    private final DepartmentRepository groupRepository; */

    @Override
    public void run(String... args) throws Exception {
    
    }
}