package com.virtualschool.learning.repository;

import com.virtualschool.learning.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query("FROM Question q where q.chapter.chapterId =:chapterId")
    List<Question> findByChapter(@Param("chapterId") Integer chapterId);
}
