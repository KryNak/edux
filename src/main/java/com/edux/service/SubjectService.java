package com.edux.service;

import com.edux.model.Student;
import com.edux.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<String> findSubjectsByStudent(Student student){
        return subjectRepository.findSubjectsByStudent(student);
    }
}
