package com.example.masterhibernateandjpa.repository;

import com.example.masterhibernateandjpa.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }

//    public void save()

    public void deleteById(long id){
        entityManager.remove(this.findById(id));
    }
}
