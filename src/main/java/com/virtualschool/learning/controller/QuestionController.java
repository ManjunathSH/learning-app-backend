package com.virtualschool.learning.controller;

import com.virtualschool.learning.entity.Question;
import com.virtualschool.learning.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/api/question/save")
    public Question saveQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

    @GetMapping("/api/question/{questionId}")
    public Optional<Question> getQuestionById(@PathVariable("questionId") Integer questionId) {
        return questionService.getQuestionById(questionId);
    }

    @GetMapping("/api/question/")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/api/question/chapter/")
    public List<Question> getQuestionsByChapter(@RequestParam(name="chapterId") Integer chapterId) {
        return questionService.getQuestionsByChapter(chapterId);
    }

}
