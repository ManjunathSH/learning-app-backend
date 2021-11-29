package com.virtualschool.learning.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "QUESTION")
public class Question {

    @Id
    @GeneratedValue
    @Column(name = "QUESTION_ID")
    private Integer questionId;

    @Column(name = "QUESTION_TEXT")
    private String questionText;

    @Column(name = "QUESTION_TAGS")
    private String questionTags;

    @ManyToOne
    @JoinColumn(name = "CHAPTER", referencedColumnName = "CHAPTER_ID", nullable=false)
    @JsonBackReference(value = "chapter-question")
    private Chapter chapter;

    // TODO add a list which has all the answers make it bi directional mapping

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionTags() {
        return questionTags;
    }

    public void setQuestionTags(String questionTags) {
        this.questionTags = questionTags;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", questionText='" + questionText + '\'' +
                ", questionTags='" + questionTags + '\'' +
                ", chapter=" + chapter +
                '}';
    }
}
