package krenc.mirek.jdbcjpa.courses.repository;

import krenc.mirek.jdbcjpa.SpringJpaCourseApplication;
import krenc.mirek.jdbcjpa.courses.entity.Course;
import krenc.mirek.jdbcjpa.courses.entity.Review;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpringJpaCourseApplication.class)
@EnableConfigurationProperties
//@ActiveProfiles("test")
class CourseRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Test
    void contextLoads() {
        logger.info("Test is running");
    }

    @Test
    void getByIdReturnsNotNull() {
        //given
        long id = 10001L;
        //when
        Course course = courseRepository.findById(id);
        //then
        assertNotNull(course);
        assertEquals("SpringBoot and JPA course", course.getName());
    }

    @Test
    @DirtiesContext
    void deleteByIdTest() {
        courseRepository.deleteById(10002L);
        assertNull(courseRepository.findById(10002L));
    }

    @Test
    @DirtiesContext
    void SaveCourseAndIsNotNull() {
        Course course = courseRepository.save(new Course("Kurs"));
        assertNotNull(course);
        assertEquals(1L, course.getId());
    }

    @Test
    void playWithEntityManagerTest() {
        courseRepository.playWithEntityManager();
    }

    @Test
    @Transactional
    @DirtiesContext
    void retrievrReviewsFromCourse() {
        Course course = courseRepository.findById(10003);
        logger.info("Reviews -> {} ", course.getReviews());
    }

    @Test
    @Transactional
    void retrieveCourseForReview() {
        Review review = reviewRepository.findById(50001);
        logger.info("Course -> {}", review.getCourse());
    }

}