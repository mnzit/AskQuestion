/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.askquestion.services;

import com.mnzit.askquestion.dto.QuestionDTO;
import com.mnzit.askquestion.models.Question;
import com.mnzit.askquestion.repositories.QuestionRepository;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class QuestionService implements GenericService<Question, QuestionDTO>{
    
    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private ModelMapper mapper;
    
    @Override
    public Question save(QuestionDTO questionDTO) {
        return questionRepository.save(mapper.map(questionDTO, Question.class));
    }
    
    @Override
    public List<Question> getAll() {
        return questionRepository.getActiveQuestions();
    }
    
    @Override
    public Question getById(Integer id) {
        if (!questionRepository.existsById(id)) {
            throw new RuntimeException("QuestionId " + id + " not found");
        }
        return questionRepository.getOne(id);
    }
    
    @Override
    public Question update(QuestionDTO questionDTO) {
        if (!questionRepository.existsById(questionDTO.getId())) {
            throw new RuntimeException("QuestionId " + questionDTO.getId() + " not found");
        }
        return questionRepository.save(mapper.map(questionDTO, Question.class));
    }
    
    @Override
    public Boolean delete(Integer id) {
        if (!questionRepository.existsById(id)) {
            throw new RuntimeException("Question " + id + " not found");
        }
        Question question = questionRepository.getOne(id);
        question.setDeletedDate(new Date());
        question.setIsDeleted(true);
        questionRepository.save(question);
        return true;
    }
    
    public List<Question> getQuestionByProfileId(Integer id) {
        return questionRepository.getActiveQuestionsByProfileId(id);
    }
    
}
