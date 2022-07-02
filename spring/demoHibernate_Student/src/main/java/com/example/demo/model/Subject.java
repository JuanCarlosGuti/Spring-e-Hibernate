package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Subjects")
@Getter @Setter
public class Subject {

    @Id
    @GeneratedValue
    Long id;

    String name;
    String leader;

    @OneToMany(mappedBy = "subject")
    @JsonIgnore
    private Set<Course> courses;
}
