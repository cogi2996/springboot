package com.example.finallabchapter4.dao;

import com.example.finallabchapter4.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save (Employee theEmployee);
    void deleteById (int theId);

}
