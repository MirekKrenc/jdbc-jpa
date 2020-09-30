package krenc.mirek.jdbcjpa.courses.repository;

import krenc.mirek.jdbcjpa.courses.entity.Course;
import krenc.mirek.jdbcjpa.courses.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
    @PersistenceContext
    EntityManager em;

    public Course findById(long id) {
        return em.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
        return course;
    }

    public void playWithEntityManager() {
        final TypedQuery<Course> courseTypedQuery = em.createNamedQuery("query_all_courses", Course.class);
        final List<Course> courseList = courseTypedQuery.getResultList();
        logger.info("Courses retrived by named query -> {} ", courseList);

        final TypedQuery<Course> paramQuery = em.createNamedQuery("name_param_query", Course.class);
        paramQuery.setParameter("name", "%course");
        final List<Course> paramQueryResultList = paramQuery.getResultList();
        logger.info("Parameterized query result -> {}", paramQueryResultList);
    }

    public void addHardcodedReviewsForCourse() {
        //get teh course
        Course course = findById(10003);
        logger.info("Course raviews -> {}", course.getReviews());
        //add a few reviews to the course
        List<Review> reviewList = new ArrayList<>();
        reviewList.add(new Review("5", "Awesome"));
        reviewList.add(new Review("5", "Great hands-on experience"));
        //save to db
        reviewList.stream()
                .forEach(r -> {
                    course.addReview(r);
                    r.setCourse(course);
                    em.persist(r);
                });
        logger.info("Course raviews -> {}", course.getReviews());
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews) {
        //get teh course
        Course course = findById(courseId);
        logger.info("Course raviews -> {}", course.getReviews());
        //save to db
        reviews.stream()
                .forEach(r -> {
                    course.addReview(r);
                    r.setCourse(course);
                    em.persist(r);
                });
        logger.info("Course raviews -> {}", course.getReviews());
    }
}
