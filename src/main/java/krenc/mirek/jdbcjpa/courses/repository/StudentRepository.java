package krenc.mirek.jdbcjpa.courses.repository;

import krenc.mirek.jdbcjpa.courses.entity.Passport;
import krenc.mirek.jdbcjpa.courses.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
    @PersistenceContext
    EntityManager em;

    public Student findById(long id) {
        return em.find(Student.class, id);
    }

    public void deleteById(long id) {
        Student student = findById(id);
        em.remove(student);
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }
        return student;
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("USSR1234");
        em.persist(passport);
        Student student = new Student("Ukson");
        student.setPassport(passport);
        em.persist(student);
    }

}
