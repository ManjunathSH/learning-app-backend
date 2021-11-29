package com.virtualschool.learning.service;

import com.virtualschool.learning.entity.Answer;
import com.virtualschool.learning.repository.AnswerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    AnswerRespository answerRespository;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    public Answer saveAnswer(Answer answer){
        return answerRespository.save(answer);
    }

    public Optional<Answer> getAnswerById(Integer answerId){
        return answerRespository.findById(answerId);
    }

    public List<Answer> getAllAnswers(){
        return answerRespository.findAll();
    }

    public List<Answer> getAnswersByQuestion(Integer questionId){
        return answerRespository.findByQuestion(questionId);

    }

    public void uploadAnswer(String url, MultipartFile file) throws URISyntaxException, IOException {

        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("file", new InputStreamResource(file.getInputStream()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);

        System.out.println(url);

        ResponseEntity<String> response = restTemplate
                .exchange(new URI(url), HttpMethod.PUT, requestEntity, String.class);

        System.out.println(response);




    }
}

