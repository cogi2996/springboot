package com.example.finallabchapter4.dao;

import com.example.finallabchapter4.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {
    EntityManager entityManager;
    @Autowired
    public EmployeeDaoJpaImpl (EntityManager theEntityManager   ){
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class,  theId);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee dbEmployee = entityManager.find(Employee.class, theId);
        entityManager.remove(dbEmployee);
    }
}
