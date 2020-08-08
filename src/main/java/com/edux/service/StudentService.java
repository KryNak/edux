package com.edux.service;

import com.edux.model.Student;
import com.edux.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class StudentService implements Serializable {

    @Autowired
    private StudentRepository studentRepository;

    public Student findStudentByLogin(String login){
        return studentRepository.findStudentByLogin(login);
    }
}
