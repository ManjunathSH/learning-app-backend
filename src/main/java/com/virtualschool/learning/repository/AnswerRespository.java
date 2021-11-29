package com.virtualschool.learning.repository;

import com.virtualschool.learning.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRespository extends JpaRepository<Answer, Integer> {

    @Query("FROM Answer a where a.question.questionId =:questionId")
    List<Answer> findByQuestion(@Param("questionId") Integer questionId);
}
