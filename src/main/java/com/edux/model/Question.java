
package com.edux.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_question;

    private String question_content;

    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public Question(){

    }

    public Long getId_question() {
        return id_question;
    }

    public void setId_question(Long id_question) {
        this.id_question = id_question;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id_question=" + id_question +
                ", question_content='" + question_content + '\'' +
                ", subject=" + subject +
                ", answers=" + answers +
                '}';
    }
}

