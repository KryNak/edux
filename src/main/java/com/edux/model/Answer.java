
package com.edux.model;

import javax.persistence.*;

@Entity(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_answer;

    private String answer_contend;
    private Boolean is_truth;

    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;

    public Answer(){

    }

    public Long getId_answer() {
        return id_answer;
    }

    public void setId_answer(Long id_answer) {
        this.id_answer = id_answer;
    }

    public String getAnswer_contend() {
        return answer_contend;
    }

    public void setAnswer_contend(String answer_contend) {
        this.answer_contend = answer_contend;
    }

    public Boolean getIs_truth() {
        return is_truth;
    }

    public void setIs_truth(Boolean is_truth) {
        this.is_truth = is_truth;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id_answer=" + id_answer +
                ", answer_content='" + answer_contend + '\'' +
                ", is_truth=" + is_truth +
                ", question=" + question +
                '}';
    }
}
