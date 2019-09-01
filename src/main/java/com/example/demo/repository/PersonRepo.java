package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person,Integer> {
    @Modifying
    @Transactional
    @Query("update Person u set u.email = :email, u.name = :name where u.personId = :personId")
    int updatePersonByPersonId(@Param("email") String email,
                                   @Param("name") String name,
                                    @Param("personId") Integer personId);

    List<Person> findAllByEmail(String email);
}
