package krenc.mirek.jdbcjpa.courses.repository;

import krenc.mirek.jdbcjpa.courses.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
    @PersistenceContext
    EntityManager em;

    public Course findById(long id) {
        return em.find(Course.class, id);
    }

    @Transactional
    public void deleteById(long id) {
        Course course = findById(id);
        em.remove(course);
    }

    @Transactional
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
}
