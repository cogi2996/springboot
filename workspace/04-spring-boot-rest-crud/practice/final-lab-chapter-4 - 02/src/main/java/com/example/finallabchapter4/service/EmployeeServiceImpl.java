package com.example.finallabchapter4.service;

import com.example.finallabchapter4.dao.EmployeeDao;
import com.example.finallabchapter4.dao.EmployeeDaoJpaImpl;
import com.example.finallabchapter4.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDao employeeDao;
    @Autowired
    public EmployeeServiceImpl (EmployeeDao theEmployeeDao ){
        employeeDao = theEmployeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDao.findById(theId);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDao.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDao.deleteById(theId);
    }
}
