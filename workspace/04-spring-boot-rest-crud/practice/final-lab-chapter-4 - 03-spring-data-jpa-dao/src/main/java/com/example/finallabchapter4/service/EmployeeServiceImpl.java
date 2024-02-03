package com.example.finallabchapter4.service;

import com.example.finallabchapter4.dao.EmployeeRepository;
import com.example.finallabchapter4.entity.Employee;
import com.example.finallabchapter4.rest.StudentException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl (EmployeeRepository theEmployeeRepository ){
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee employee = null;
        if(result.isPresent()){
            employee =  result.get();
        }
        else {
            throw new StudentException("not found employee id - " + theId);
        }
        return employee;
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
