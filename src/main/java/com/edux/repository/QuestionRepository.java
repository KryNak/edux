package com.edux.repository;

import com.edux.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "SELECT q FROM question q INNER JOIN q.subject s WHERE s.subject_name = :sub")
    List<Question> findQuestionsBySubjectName(@Param(value = "sub") String subject_name);
}
