package com.virtualschool.learning.controller;

import com.virtualschool.learning.entity.Answer;
import com.virtualschool.learning.entity.Question;
import com.virtualschool.learning.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping("/api/answer/save")
    public Answer saveAnswer(@RequestBody Answer answer) {
        return answerService.saveAnswer(answer);
    }

    @GetMapping("/api/answer/{answerId}")
    public Optional<Answer> getAnswerById(@PathVariable("answerId") Integer answerId) {
        return answerService.getAnswerById(answerId);
    }

    @GetMapping("/api/answer")
    public List<Answer> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    @GetMapping("/api/answer/question/")
    public List<Answer> getAnswersByQuestion(@RequestParam(name="questionId") Integer questionId) {
        return answerService.getAnswersByQuestion(questionId);
    }

    @PostMapping("/api/answer/upload")
    public void uploadAnswer(@RequestParam(name="url") String url, @RequestParam("file") MultipartFile file ) throws URISyntaxException, IOException {
        System.out.println(url);
         answerService.uploadAnswer(url, file);
    }

}
