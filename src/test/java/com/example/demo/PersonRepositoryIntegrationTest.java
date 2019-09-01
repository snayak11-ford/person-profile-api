package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryIntegrationTest {

    @Autowired
    private PersonRepo personRepo;

    @Test
    public void whenCalledSave_thenCorrectNumberOfUsers() {
        personRepo.save(new Person("siddu","sid@gmail.com"));
        personRepo.save(new Person("siddu","sid@gmail.com"));
        List<Person> users =  personRepo.findAll();
        assertThat(users.size()).isEqualTo(4);
        personRepo.findAll().forEach(person -> System.out.println(person.getName()+","+person.getEmail()));
    }
}