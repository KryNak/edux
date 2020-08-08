package com.edux.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_person;

    private String first_name;
    private String last_name;

    @OneToOne(mappedBy = "person")
    private Student student;

    public Person(){

    }

    public Long getId_person() {
        return id_person;
    }

    public void setId_person(Long id_person) {
        this.id_person = id_person;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id_person=" + id_person +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", student=" + student +
                '}';
    }
}
