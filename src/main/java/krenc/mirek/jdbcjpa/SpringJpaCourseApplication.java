package krenc.mirek.jdbcjpa;

import krenc.mirek.jdbcjpa.courses.entity.Course;
import krenc.mirek.jdbcjpa.courses.entity.Review;
import krenc.mirek.jdbcjpa.courses.entity.Student;
import krenc.mirek.jdbcjpa.courses.repository.CourseRepository;
import krenc.mirek.jdbcjpa.courses.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringJpaCourseApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaCourseApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		logger.info("---------------------Application started -------------------");
		//studentRepository.saveStudentWithPassport();
//		courseRepository.addHardcodedReviewsForCourse();

//		List<Review> reviewList = new ArrayList<>();
//		reviewList.add(new Review("5", "Awesome"));
//		reviewList.add(new Review("5", "Great hands-on experience"));
//
//		courseRepository.addReviewsForCourse(10003L, reviewList);
		Student student = new Student("Jackie");
		Course course = new Course("Hibernate and JPA");
		studentRepository.insertStudentAndCourse(student, course);
	}
}
