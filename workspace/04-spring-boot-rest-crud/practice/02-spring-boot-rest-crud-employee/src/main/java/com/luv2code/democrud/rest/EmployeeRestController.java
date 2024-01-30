package com.luv2code.democrud.rest;

import com.luv2code.democrud.entity.Employee;
import com.luv2code.democrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return  employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee =  employeeService.save(theEmployee);
        return  dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);
        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found - "+ employeeId);
        }
        employeeService.deleteById(employeeId);
        return  "Delete employee id - " + employeeId;
    }

}
