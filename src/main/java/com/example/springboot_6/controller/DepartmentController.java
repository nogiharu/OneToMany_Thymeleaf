package com.example.springboot_6.controller;

import java.util.List;

import com.example.springboot_6.model.Department;
import com.example.springboot_6.model.Employee;
import com.example.springboot_6.repository.DepartmentRepository;
import com.example.springboot_6.repository.EmployeeRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DepartmentController {
    
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String show(Department department,Model model,Employee employee) {

        //部門１を指定
        department  = departmentRepository.findById(1).get();

        //社員をセット
        employee.setName("Fugaaaaaa");
        //社員を部門１をセット
        employee.setDepartment(department);
        employeeRepository.save(employee);
        
        List<Department> list = departmentRepository.findAll();

        model.addAttribute("department",list);

        model.addAttribute("employee", departmentRepository.findById(1).get().getEmployeeList());
        model.addAttribute("totalEmp", departmentRepository.findById(1).get().getEmployeeList().size());
        return "departmentList";
    }

    @GetMapping("/emp")
    public String showEmp(Employee employee,Model model) {
        System.out.println(employeeRepository.findAll());
        model.addAttribute("employee",employeeRepository.findAll());
        //model.addAttribute("dpt", department.getEmployeeList());
        return "employeeList";
    }
}