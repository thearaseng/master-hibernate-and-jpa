package com.example.masterhibernateandjpa.repository;

import com.example.masterhibernateandjpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    @Autowired
    EntityManager entityManager;

    public Employee findById(long id){
        return entityManager.find(Employee.class, id);
    }

    public void saveEmployee(Employee employee){
        entityManager.persist(employee);
    }

    public List<Employee> getAllEmployee(){
        return entityManager.createQuery("SELECT E FROM Employee E", Employee.class).getResultList();
    }

}
