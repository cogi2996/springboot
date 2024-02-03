package com.example.finallabchapter4.service;

import com.example.finallabchapter4.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save (Employee theEmployee);
    void deleteById (int theId);
}
