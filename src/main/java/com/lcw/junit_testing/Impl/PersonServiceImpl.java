package com.lcw.junit_testing.Impl;

import com.lcw.junit_testing.entity.Person;
import com.lcw.junit_testing.repository.PersonRepository;
import com.lcw.junit_testing.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<Person> getAllPerson() {
        return this.personRepository.findAll();
    }

    @Override
    public Person getPersonById(Integer id) {
        Optional<Person> person = this.personRepository.findById(id);
        return person.orElse(null);
    }

    @Override
    public void deletePerson(Integer id) {
        this.personRepository.deleteById(id);

    }

    @Override
    public Person createPerson(Person person) {
        return this.personRepository.save(person);
    }

}
