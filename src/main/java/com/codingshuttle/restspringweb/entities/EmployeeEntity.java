package com.codingshuttle.restspringweb.entities;


import jakarta.persistence.*;
import org.springframework.data.jpa.repository.EntityGraph;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    private Boolean isActive;


}
