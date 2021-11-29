package com.virtualschool.learning.controller;

import com.virtualschool.learning.entity.Subject;
import com.virtualschool.learning.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping(path="/api/subject/save")
    public Subject save(@RequestBody Subject subject){

        return subjectService.saveSubject(subject);
    }

    @GetMapping(path = "/api/subject/{subjectId}")
    public Optional<Subject> getSubjectById(@PathVariable(name="subjectId")Integer subjectId){
        return subjectService.getSubjectById(subjectId);
    }

    @GetMapping(path = "/api/subject/")
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @GetMapping(path = "/api/subject/board/")
    public List<Subject> getSubjectByBoardAndClass(@RequestParam(name="boardId")Integer boardId, @RequestParam(name="class")String className){
        return subjectService.getSubjectByBoardAndClass(boardId, className);
    }
}
