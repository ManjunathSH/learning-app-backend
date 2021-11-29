package com.virtualschool.learning.entity;

import javax.persistence.*;

@Entity
@Table(name = "FEEDBACK")
public class Feedback {

    @Id
    @GeneratedValue
    @Column(name = "FEEDBACK_ID")
    private Integer feedbackId;

    @Column(name = "FEEDBACK_TEXT")
    private String feedbackText;

    @ManyToOne
    @JoinColumn(name = "USER", referencedColumnName = "USER_ID")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "ANSWER", referencedColumnName = "ANSWER_ID")
    private Answer answerId;

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Answer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Answer answerId) {
        this.answerId = answerId;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + feedbackId +
                ", feedbackText='" + feedbackText + '\'' +
                ", userId=" + userId +
                ", answerId=" + answerId +
                '}';
    }
}
