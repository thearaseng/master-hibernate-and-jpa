package com.example.masterhibernateandjpa.repository;

import com.example.masterhibernateandjpa.entity.Course;
import com.example.masterhibernateandjpa.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }

    public Course save(Course course){
        if(course.getId() == null){
            entityManager.persist(course);
        }else {
            entityManager.merge(course);
        }
        return course;
    }

    public void deleteById(long id){
        entityManager.remove(this.findById(id));
    }

    public void addSomeReviews(){
        Course course = entityManager.find(Course.class, 10002L);
        System.out.println("------------ Reviews from Course ID : 10002 ---------------------");
        List<Review> reviews = course.getReviews();
        System.out.println(reviews);

        Review review1 = new Review("8", "Description 8");
        Review review2 = new Review("7", "Description 7");

        review1.setCourse(course);
        review2.setCourse(course);

        entityManager.persist(review1);
        entityManager.persist(review2);

        entityManager.flush();

        course = entityManager.find(Course.class, 10002L);
        System.out.println("------------ Reviews from Course ID : 10002 after insert more 2 reviews ---------------------");
        System.out.println(course.getReviews());
        System.out.println("----- We don't get new inserted review after insertion, because it's not really persisted to the database");

    }

    public void playWithEntityManager(){
        Course course = new Course("Java Developer");
        entityManager.persist(course);

        /***********************************************************
        entityManager.flush();
        entityManager.clear();
        entityManager.detach(course);
        flush() -> commit to the database
        clear() -> clear detach all the following transactions
        detach() -> detach the specified object from the transaction
        refresh() -> restore the data from the database
        ***********************************************************/

//        course.setName("Java Developer - updated");
    }

}
