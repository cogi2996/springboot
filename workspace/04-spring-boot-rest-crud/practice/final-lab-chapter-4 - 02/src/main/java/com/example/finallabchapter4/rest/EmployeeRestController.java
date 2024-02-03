package com.example.finallabchapter4.rest;

import com.example.finallabchapter4.entity.Employee;
import com.example.finallabchapter4.service.EmployeeService;
import com.example.finallabchapter4.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeBy(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new StudentException("Student id not available - " + employeeId);
        }
        return employeeService.findById(employeeId);
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id id not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return " Deleted employee id - " + employeeId;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

}
