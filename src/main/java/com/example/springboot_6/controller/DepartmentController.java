package com.example.springboot_6.controller;

import java.util.List;

import com.example.springboot_6.model.Department;
import com.example.springboot_6.model.Employee;
import com.example.springboot_6.model.Task;
import com.example.springboot_6.repository.DepartmentRepository;
import com.example.springboot_6.repository.EmployeeRepository;
import com.example.springboot_6.repository.TaskRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DepartmentController {
    
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;

    @GetMapping("/")
    public String show(Department department,Model model,Employee employee) {

        //部門１を指定
       /*  System.out.println(departmentRepository.findAll()); */
        //社員をセット
        department = departmentRepository.getById(2);
        
        employee.setName("Fugaaaa");
        //employee.setId(98);
        //社員を部門１をセット
        employee.setDepartment(department);
        employeeRepository.save(employee);
        
        List<Department> list = departmentRepository.findAll();

        model.addAttribute("department",list);

     /*    model.addAttribute("employee", departmentRepository.findById(1).get().getEmployeeList());
        model.addAttribute("totalEmp", departmentRepository.findById(1).get().getEmployeeList().size()); */
        return "departmentList";
    }

    @GetMapping("/emp")
    public String showEmp(Employee employee,Model model,Task task) {
        employee = employeeRepository.getById(1);
        task.setEmployeeName(employee.getName());
        task.setEmployeeId(employee);
        task.setSales(1000);
        taskRepository.save(task);
        model.addAttribute("employee",employeeRepository.findById(1).get().getTaskList());
        //model.addAttribute("dpt", department.getEmployeeList());
        return "employeeList";
    }
}