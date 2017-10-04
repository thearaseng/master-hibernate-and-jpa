package com.example.masterhibernateandjpa.repository;

import com.example.masterhibernateandjpa.entity.Passport;
import com.example.masterhibernateandjpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager entityManager;

    public Student findById(long id){
        return entityManager.find(Student.class, id);
    }

    public Student save(Student student){
        if(student.getId() == null){
            entityManager.persist(student);
        }else {
            entityManager.merge(student);
        }
        return student;
    }

    public void deleteById(long id){
        entityManager.remove(this.findById(id));
    }

    public void saveStudentWithPassport(){
        Passport passport = new Passport("B88488554");
        entityManager.persist(passport);

        Student student = new Student("Kim Chanly");
        student.setPassport(passport);
        entityManager.persist(student);
    }

    public void retrieveStudentAndPassport(){
        Student student = this.findById(20001);
        System.out.println(student);
        System.out.println(student.getPassport());

        System.out.println("------------------------------");
        Passport passport = entityManager.find(Passport.class, 40001L);
        System.out.println(passport);
        System.out.println(passport.getStudent());
    }

}
