package com.virtualschool.learning.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CHAPTER")
public class Chapter {

    @Id
    @GeneratedValue
    @Column(name = "CHAPTER_ID")
    private Integer chapterId;

    @Column(name = "CHAPTER_NAME")
    private String chapterName;

    @Column(name = "CHAPTER_NUMBER")
    private String chapterNumber;

    @ManyToOne
    @JoinColumn(name = "SUBJECT", referencedColumnName = "SUBJECT_ID")
    @JsonBackReference(value = "chapter-subject")
    private Subject subject;

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "chapter-question")
    private Set<Question> questions;

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(String chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "chapterId=" + chapterId +
                ", chapterName='" + chapterName + '\'' +
                ", chapterNumber='" + chapterNumber + '\'' +
                ", subject=" + subject +
                ", questions=" + questions +
                '}';
    }
}
