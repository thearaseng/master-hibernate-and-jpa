package com.example.masterhibernateandjpa.repository;

import com.example.masterhibernateandjpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
}
