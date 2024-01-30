package com.luv2code.democrud.service;

import com.luv2code.democrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save (Employee theEmployee);
    void deleteById(int theId);
}
