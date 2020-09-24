package krenc.mirek.jdbcjpa.dao.jdbc;

import krenc.mirek.jdbcjpa.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class PersonJdbcDAO {

    private final JdbcTemplate jdbcTemplate;
    //private final DataSource dataSource;
    @Autowired
    public PersonJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int i) throws SQLException {
            return new Person (
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDate(4)
            );
        }
    }


    public Set<Person> findAll() {
        //remove duplicates
        Set<Person> personSet = new HashSet<>(jdbcTemplate.query("select * from person",
                new BeanPropertyRowMapper<>(Person.class)));
        return personSet;
    }

    public Optional<Person> findById(int id) {
        Person person = null;
        try {
            person = jdbcTemplate.queryForObject("select * from person where id=?", new Object[]{id}, new BeanPropertyRowMapper<Person>(Person.class));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
        return Optional.of(person);
    }

    public List<Person> findByName(String name) {
        List<Person> lista =
        jdbcTemplate.query("select * from person where name like ?", new Object[]{name}, (resultSet, i) ->
                new Person (
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4)
                ));
        return lista;
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id = ?", new Object[]{ id });
    }

    public List<Person> findByNameCustomRM(String name) {
        return jdbcTemplate.query("select * from person where name like ?", new Object[]{name}, new PersonRowMapper());
    }

}
