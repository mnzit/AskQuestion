/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.askquestion.resources;

import com.mnzit.askquestion.dto.AnswerDTO;
import com.mnzit.askquestion.models.Answer;
import com.mnzit.askquestion.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class AnswerResource {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/answer/save")
    public ResponseEntity<Answer> saveAnswer(@RequestBody AnswerDTO answerDTO) {
        return new ResponseEntity<>(answerService.save(answerDTO), HttpStatus.OK);
    }

    @PutMapping("/answer/update")
    public ResponseEntity<Answer> updateQuestion(@RequestBody AnswerDTO answerDTO) {
        return new ResponseEntity<>(answerService.update(answerDTO), HttpStatus.OK);
    }

    @DeleteMapping("/answer/delete/{id}")
    public ResponseEntity<Boolean> deleteQuestion(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(answerService.delete(id), HttpStatus.OK);
    }
}
