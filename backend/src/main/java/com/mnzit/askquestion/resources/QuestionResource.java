/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.askquestion.resources;

import com.mnzit.askquestion.dto.QuestionDTO;
import com.mnzit.askquestion.models.Question;
import com.mnzit.askquestion.repositories.QuestionRepository;
import com.mnzit.askquestion.services.QuestionService;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dell
 */
@RestController
@RequestMapping("/api/v1/")
public class QuestionResource {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/question/save")
    public ResponseEntity<Question> saveAnswer(@RequestBody QuestionDTO questionDTO) {
        return new ResponseEntity<>(questionService.save(questionDTO), HttpStatus.OK);
    }

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getQuestions() {
        return new ResponseEntity<>(questionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/questions/{id}")
    public ResponseEntity<List<Question>> getQuestionsByProfileId(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(questionService.getQuestionByProfileId(id), HttpStatus.OK);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(questionService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/question/update")
    public ResponseEntity<Question> updateQuestion(@RequestBody QuestionDTO questionDTO) {
        return new ResponseEntity<>(questionService.update(questionDTO), HttpStatus.OK);
    }

    @DeleteMapping("/question/delete/{id}")
    public ResponseEntity<Boolean> deleteQuestion(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(questionService.delete(id), HttpStatus.OK);
    }
}
