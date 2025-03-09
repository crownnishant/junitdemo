package com.lcw.junit_testing.service;

import com.lcw.junit_testing.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAllPerson();

    Person getPersonById(Integer id);

    void deletePerson(Integer id);

    Person createPerson(Person person);

}