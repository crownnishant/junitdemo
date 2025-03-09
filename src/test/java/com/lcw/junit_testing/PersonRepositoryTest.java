package com.lcw.junit_testing;

import com.lcw.junit_testing.entity.Person;
import com.lcw.junit_testing.repository.PersonRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void isPersonExistsById(){
        Person person=new Person(1234, "Nishant", "Bangalore");
        personRepository.save(person);

        Boolean actualResult = personRepository.isPersonExistsById(1234);
        assertThat(actualResult).isTrue();
    }

    @AfterEach
    void tearDown(){
        System.out.println("Cleaning db after test");
        personRepository.deleteAll();
    }

    @BeforeEach
    void setUp(){
        System.out.println("setting up");
    }
}
