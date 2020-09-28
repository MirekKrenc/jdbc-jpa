package krenc.mirek.jdbcjpa;

import krenc.mirek.jdbcjpa.courses.entity.Course;
import krenc.mirek.jdbcjpa.courses.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaCourseApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaCourseApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		logger.info("---------------------Application started -------------------");
		logger.info("Course with id 10001 -> {}", courseRepository.findById(10001L));
//		logger.info("delete course with id 10001");
//		courseRepository.deleteById(10001);
//		logger.info("Saving new course -> {} ", courseRepository.save(new Course("Best you")));
	}
}
