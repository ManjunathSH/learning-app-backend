package com.virtualschool.learning.controller;

import com.virtualschool.learning.entity.Feedback;
import com.virtualschool.learning.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @PostMapping(path="/api/feedback/save")
    public Feedback save(@RequestBody Feedback feedback){

        return feedbackService.saveFeedback(feedback);
    }

    @GetMapping(path = "/api/feedback/{feedbackId}")
    public Optional<Feedback> getFeedbackById(@PathVariable(name="feedbackId")Integer feedbackId){
        return feedbackService.getFeedbackById(feedbackId);
    }

    @GetMapping(path = "/api/feedback/")
    public List<Feedback> getAllFeedbacks(){
        return feedbackService.getAllFeedbacks();
    }
}
