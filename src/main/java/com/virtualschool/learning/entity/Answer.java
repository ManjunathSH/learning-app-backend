package com.virtualschool.learning.entity;

import javax.persistence.*;

@Entity
@Table(name = "ANSWER")
public class Answer {

    @Id
    @GeneratedValue
    @Column(name = "ANSWER_ID")
    private Integer answerId;

    @Column(name = "ANSWER_TEXT")
    private String answerText;

    @Column(name = "ANSWER_URL")
    private String answerUrl;

    @ManyToOne
    @JoinColumn(name = "QUESTION", referencedColumnName = "QUESTION_ID", nullable=false)
    private Question question;

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public String getAnswerUrl() {
        return answerUrl;
    }

    public void setAnswerUrl(String answerUrl) {
        this.answerUrl = answerUrl;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", answerText='" + answerText + '\'' +
                ", answerUrl='" + answerUrl + '\'' +
                ", question=" + question +
                '}';
    }
}
