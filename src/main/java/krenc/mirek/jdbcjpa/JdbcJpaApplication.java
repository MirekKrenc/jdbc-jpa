package krenc.mirek.jdbcjpa;

import krenc.mirek.jdbcjpa.dao.jdbc.PersonJdbcDAO;
import krenc.mirek.jdbcjpa.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import java.util.Optional;

@SpringBootApplication
public class JdbcJpaApplication {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonJdbcDAO personJdbcDAO;

	public static void main(String[] args) {
		SpringApplication.run(JdbcJpaApplication.class, args);
	}

	@Bean
	@EventListener(ApplicationReadyEvent.class)
	public void getPersonsFromDB() {
		personJdbcDAO.findAll()
				.stream()
				.forEach(p -> logger.info("Person {} ", p.toString()));

		System.out.println("------------------------------");

		int id = 10001;
		Optional<Person> personOptional = personJdbcDAO.findById(id);
		if (personOptional.isPresent()) {
			Person p = personOptional.get();
			logger.info("Znaleziono osobe o id {} -> {}", id, p.toString());
		}
		System.out.println("------------------------------");

		personJdbcDAO.findByName("Mirek")
				.stream()
				.forEach(p -> logger.info("Wg nazwy {} ", p.toString()));

		System.out.println("------------------------------");

		personJdbcDAO.findByNameCustomRM("Mirek")
				.stream()
				.forEach(p -> logger.info("Wg nazwy with custom RowMapper {} ", p.toString()));

		System.out.println("------------------------------");

		int deletedCount = personJdbcDAO.deleteById(10004);
		logger.info("Deleted {} rows ", deletedCount);

		System.out.println("------------------------------");

		personJdbcDAO.findAll()
				.stream()
				.forEach(p -> logger.info("Person {} ", p.toString()));
	}

}
