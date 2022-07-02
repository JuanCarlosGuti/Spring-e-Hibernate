package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "Students")
@Getter @Setter
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String lastname;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private Set<Course> courses;


}
