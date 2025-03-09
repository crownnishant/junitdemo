package com.lcw.junit_testing.controller;

import com.lcw.junit_testing.entity.Person;
import com.lcw.junit_testing.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/junit")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.ok(personService.getAllPerson());
    }

}
