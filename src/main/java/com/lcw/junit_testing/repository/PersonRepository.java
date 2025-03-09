package com.lcw.junit_testing.repository;

import com.lcw.junit_testing.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM Person p WHERE p.id = :id")
    Boolean isPersonExistsById(@Param("id") Integer id);
}

