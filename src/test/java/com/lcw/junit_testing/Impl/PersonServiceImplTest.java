package com.lcw.junit_testing.Impl;

import com.lcw.junit_testing.entity.Person;
import com.lcw.junit_testing.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    private List<Person> mockPersons;
    private Person mockPerson;

    @BeforeEach
    void setUp() {
        mockPerson = new Person(222, "Jugnu", "Delhi");
        mockPersons = Arrays.asList(mockPerson);
    }

    @Test
    void getAllPerson() {
        when(personRepository.findAll()).thenReturn(mockPersons);

        List<Person> persons = personService.getAllPerson();

        assertNotNull(persons);
        assertEquals(1, persons.size());
        verify(personRepository, times(1)).findAll();
    }

    @Test
    void getPersonById() {
        when(personRepository.findById(222)).thenReturn(Optional.of(mockPerson));

        Person person = personService.getPersonById(222);

        assertNotNull(person);
        assertEquals("Jugnu", person.getName());
        verify(personRepository, times(1)).findById(222);
    }

    @Test
    void deletePerson() {
        doNothing().when(personRepository).deleteById(222);

        personService.deletePerson(222);

        verify(personRepository, times(1)).deleteById(222);
    }

    @Test
    void createPerson() {
        when(personRepository.save(mockPerson)).thenReturn(mockPerson);

        Person person = personService.createPerson(mockPerson);

        assertNotNull(person);
        assertEquals("Jugnu", person.getName());
        verify(personRepository, times(1)).save(mockPerson);
    }
}