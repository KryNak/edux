package com.edux.repository;

import com.edux.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query(value = "SELECT a FROM answer a INNER JOIN a.question q WHERE q.id_question = :id")
    List<Answer> findAnswersById_question(@Param(value = "id") Long id_question);

    @Query(value = "SELECT a FROM answer a INNER JOIN a.question q WHERE q.id_question = :id AND a.is_truth = true")
    Answer findCorrectAnswerById_question(@Param(value = "id") Long id_question);

}
