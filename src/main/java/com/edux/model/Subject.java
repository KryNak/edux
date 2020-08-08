package com.edux.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_subject;

    private String subject_name;

    @ManyToMany(mappedBy = "subjects", fetch = FetchType.LAZY)
    private List<Student> students;

    //@OneToMany(mappedBy = "subject")
    //private List<Question> questions;

    public Subject(){

    }

    public Long getId_subject() {
        return id_subject;
    }

    public void setId_subject(Long id_subject) {
        this.id_subject = id_subject;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /*
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id_subject=" + id_subject +
                ", subject_name='" + subject_name + '\'' +
                ", students=" + students +
                ", questions=" + questions +
                '}';
    }

     */
}
