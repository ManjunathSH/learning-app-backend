package com.virtualschool.learning.repository;

import com.virtualschool.learning.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    @Query("FROM Subject s where s.board.boardId =:boardId and s.className =:className")
    List<Subject> findByBoardAndClass(@Param("boardId") Integer boardId, @Param("className")String className);
}
