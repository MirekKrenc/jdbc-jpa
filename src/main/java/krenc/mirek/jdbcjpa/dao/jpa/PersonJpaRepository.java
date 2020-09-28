package krenc.mirek.jdbcjpa.dao.jpa;

import krenc.mirek.jdbcjpa.domain.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

//@Repository
//@Transactional
public class PersonJpaRepository {

    //connect to database
    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public void updateInsert(Person p) {
        entityManager.merge(p);
    }

    public Person deleteById(int id) {
        Person toDelPerson = findById(id);
        entityManager.remove(toDelPerson);

        return toDelPerson;
    }

    public List<Person> findAll() {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }
}
