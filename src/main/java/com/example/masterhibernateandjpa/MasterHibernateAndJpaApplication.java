package com.example.masterhibernateandjpa;

import com.example.masterhibernateandjpa.entity.Course;
import com.example.masterhibernateandjpa.entity.Employee;
import com.example.masterhibernateandjpa.entity.FullTimeEmployee;
import com.example.masterhibernateandjpa.entity.PartTimeEmployee;
import com.example.masterhibernateandjpa.repository.CourseRepository;
import com.example.masterhibernateandjpa.repository.CourseSpringDataRepository;
import com.example.masterhibernateandjpa.repository.EmployeeRepository;
import com.example.masterhibernateandjpa.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MasterHibernateAndJpaApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CourseSpringDataRepository courseSpringDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(MasterHibernateAndJpaApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		/*
		Course course = courseRepository.findById(10001);
		logger.info("Course id 10001 - {}", course);
		courseRepository.deleteById(10001);
		courseRepository.save(new Course("Sql developer"));

		courseRepository.playWithEntityManager();

		studentRepository.saveStudentWithPassport();

		studentRepository.retrieveStudentAndPassport();

		courseRepository.addSomeReviews();

		studentRepository.insertStudentAndCourse();

		Employee partTimeEmployee = new PartTimeEmployee("Vuthy", new BigDecimal(50));
		Employee fullTimeEmployee = new FullTimeEmployee("Dara", new BigDecimal(1000));

		employeeRepository.saveEmployee(partTimeEmployee);
		employeeRepository.saveEmployee(fullTimeEmployee);

		List<Employee> employees = employeeRepository.getAllEmployee();

		logger.info("All employees -> {}", employees);

		courseRepository.getCourseUsingJpql();

		courseRepository.testCriteriaQuery();
		*/

		Optional<Course> courseOptional = courseSpringDataRepository.findById(10001L);
		if(courseOptional.isPresent()){
			System.out.println(courseOptional.get().toString());
		}

		Sort sort = new Sort(Sort.Direction.DESC, "name").and(new Sort(Sort.Direction.DESC, "id"));
		List<Course> courses = courseSpringDataRepository.findAll(sort);
		System.out.println(courses);
	}
}
