package com.example.finallabchapter4.dao;

import com.example.finallabchapter4.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
