package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepo personRepo;

    public String create(Person person){
        personRepo.save(person);
        return "Person created successfully";
    }

    public Person retrieveById(int personId){
        return personRepo.findById(personId).get();
    }

    public List<Person> retrieve(){
        return personRepo.findAll();
    }

    public String update(Person personNew, int personId){
        Person orginalPerson = personRepo.findById(personId).get();
        if(personNew.getEmail() == null){
            personNew.setEmail(orginalPerson.getEmail());
        }
        if(personNew.getName() == null){
            personNew.setName(orginalPerson.getName());
        }
        personRepo.updatePersonByPersonId(personNew.getEmail(),personNew.getName(),personId);
        return "Updated Successfully";
    }

    public String delete(int personId){
        personRepo.delete(personRepo.findById(personId).get());
        return "Record deleted successfully";
    }

    public List<Person> search(String key) {
        return personRepo.findAllByEmail(key);
    }
}
