package com.lcw.junit_testing.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="persons")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Person {

    @Id
    private Integer id;
    private String name;
    private String city;

}
