package com.edux.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "student")
public class Student {

    @Id
    private Long id_person;

    private String login;
    private String password;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_person")
    private Person person;

    @ManyToMany
    @JoinTable(name = "student_subject",
            joinColumns = @JoinColumn(name = "id_person"),
            inverseJoinColumns = @JoinColumn(name = "id_subject"))
    private List<Subject> subjects;

    public Long getId_person() {
        return id_person;
    }

    public void setId_person(Long id_person) {
        this.id_person = id_person;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id_person=" + id_person +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", person=" + person +
                ", subjects=" + subjects +
                '}';
    }
}
