package com.virtualschool.learning.service;

import com.virtualschool.learning.entity.Chapter;
import com.virtualschool.learning.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChapterService {

    @Autowired
    ChapterRepository chapterRepository;

    public Chapter saveChapter(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    public Optional<Chapter> getChapterById(Integer chapterId) {
        return chapterRepository.findById(chapterId);
    }

    public List<Chapter> getAllChapters() {
        return chapterRepository.findAll();
    }
}
