package com.example.masterhibernateandjpa;

import com.example.masterhibernateandjpa.entity.Course;
import com.example.masterhibernateandjpa.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MasterHibernateAndJpaApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(MasterHibernateAndJpaApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		Course course = courseRepository.findById(10001);
		logger.info("Course id 10001 - {}", course);
		courseRepository.deleteById(10001);
		courseRepository.save(new Course("Sql developer"));

		courseRepository.playWithEntityManager();

	}
}
