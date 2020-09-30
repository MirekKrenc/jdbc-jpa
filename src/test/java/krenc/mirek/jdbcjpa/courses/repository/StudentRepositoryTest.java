package krenc.mirek.jdbcjpa.courses.repository;

import krenc.mirek.jdbcjpa.SpringJpaCourseApplication;
import krenc.mirek.jdbcjpa.courses.entity.Passport;
import krenc.mirek.jdbcjpa.courses.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpringJpaCourseApplication.class)
class StudentRepositoryTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentRepository studentRepository;

    @PersistenceContext
    private EntityManager em;

    @Test
    @Transactional
    void retieveStudentAndPassport() {
        final Student student = em.find(Student.class, 20001l);
        logger.info("Student -> {}", student);
        final Passport passport = student.getPassport();
        logger.info("Passport -> {}", passport);
    }

}