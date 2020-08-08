package com.edux.service;

import com.edux.model.Question;
import com.edux.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> findQuestionsBySubjectName(@Param(value = "sub") String subject_name){
        return questionRepository.findQuestionsBySubjectName(subject_name);
    }
}
