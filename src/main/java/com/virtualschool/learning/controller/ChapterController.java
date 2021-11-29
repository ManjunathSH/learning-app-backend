package com.virtualschool.learning.controller;

import com.virtualschool.learning.entity.Chapter;
import com.virtualschool.learning.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ChapterController {

    @Autowired
    ChapterService chapterService;

    @PostMapping(path = "/api/chapter/save")
    public Chapter saveChapter(@RequestBody Chapter chapter) {
        return chapterService.saveChapter(chapter);
    }

    @GetMapping(path = "/api/chapter/{chapterId}")
    public Optional<Chapter> getChapterById(@PathVariable("chapterId") Integer chapterId) {
        return chapterService.getChapterById(chapterId);
    }

    @GetMapping(path = "/api/chapter/")
    public List<Chapter> getAllChapters() {
        return chapterService.getAllChapters();
    }

}
