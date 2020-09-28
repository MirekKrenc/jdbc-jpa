package krenc.mirek.jdbcjpa;

import krenc.mirek.jdbcjpa.dao.jpa.PersonJpaRepository;
import krenc.mirek.jdbcjpa.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import java.util.Date;

//@SpringBootApplication
public class SpringJpaApplication {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonJpaRepository personJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Bean
	@EventListener(ApplicationReadyEvent.class)
	public void getJpaPersonsFromDB() {

		personJpaRepository.updateInsert(new Person("Mirek", "Dobron", new Date()));
		personJpaRepository.updateInsert(new Person("Ania", "Lublin", new Date()));
		personJpaRepository.updateInsert(new Person("Adam", "Warszawa", new Date()));
		personJpaRepository.updateInsert(new Person("Mirek", "Dobron", new Date()));

		logger.info("JPA - Person id 10001 -> {}", personJpaRepository.findById(10001));

		logger.info("Deleted person {} ", personJpaRepository.deleteById(10004));

		logger.info("All persons -> {} ", personJpaRepository.findAll());
	}

}
