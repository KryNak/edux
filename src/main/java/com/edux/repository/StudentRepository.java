package com.edux.repository;

import com.edux.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentByLogin(String login);
}
