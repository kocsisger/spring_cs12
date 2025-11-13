package hu.unideb.inf.SpringDataFX.backend;

import hu.unideb.inf.SpringDataFX.backend.model.Person;
import hu.unideb.inf.SpringDataFX.backend.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SpringDataFxApplication implements CommandLineRunner {
	@Autowired
	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataFxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person p = new Person();
		p.setName("Klára");
		p.setDateOfBirth(LocalDate.of(1952,8, 6));

		Person p2 = Person.builder()
				.name("György")
				.dateOfBirth(LocalDate.of(1939, 1, 4))
				.build();

		personRepository.save(p);
	}
}
