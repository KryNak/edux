package com.edux.repository;

import com.edux.model.Student;

import java.util.List;

public interface FindSubjectsByStudentRepository {

    List<String> findSubjectsByStudent(Student student);

}
