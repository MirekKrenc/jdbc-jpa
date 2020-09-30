package krenc.mirek.jdbcjpa.courses.repository;

import krenc.mirek.jdbcjpa.courses.entity.Review;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ReviewRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Review findById(long id) {
        return entityManager.find(Review.class, id);
    }

}
