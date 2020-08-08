
package com.edux.service;

import com.edux.model.Answer;
import com.edux.model.Question;
import com.edux.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public List<Answer> findAnswersByQuestion(Question question){
        return answerRepository.findAnswersById_question(question.getId_question());
    }

    public Answer findCorrectAnswerByQuestion(Question question){
        return answerRepository.findCorrectAnswerById_question(question.getId_question());
    }
}

