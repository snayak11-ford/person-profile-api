package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(PersonRepo personRepo) throws Exception {
		return (String[] args) -> {
			Person person1 = new Person("John", "john@domain.com");
			Person person2 = new Person("Julie", "julie@domain.com");
			personRepo.save(person1);
			personRepo.save(person2);
			personRepo.findAll().forEach(person -> System.out.println(person.getName()));
		};
	}
}
