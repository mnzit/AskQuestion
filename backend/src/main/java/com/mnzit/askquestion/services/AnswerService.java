/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.askquestion.services;

import com.mnzit.askquestion.dto.AnswerDTO;
import com.mnzit.askquestion.models.Answer;
import com.mnzit.askquestion.repositories.AnswerRepository;
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
public class AnswerService implements GenericService<Answer, AnswerDTO> {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Answer save(AnswerDTO dto) {
        if (!questionRepository.existsById(dto.getQuestionId())) {
            throw new RuntimeException("Question " + dto.getQuestionId() + " not found");
        }
        return answerRepository.save(mapper.map(dto, Answer.class));
    }

    @Override
    public List<Answer> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Answer getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Answer update(AnswerDTO dto) {
        if (!questionRepository.existsById(dto.getId())) {
            throw new RuntimeException("QuestionId " + dto.getQuestionId() + " not found");
        }
        return answerRepository.save(mapper.map(dto, Answer.class));
    }

    @Override
    public Boolean delete(Integer id) {
        if (!answerRepository.existsById(id)) {
            throw new RuntimeException("Question " + id + " not found");
        }
        Answer answer = answerRepository.getOne(id);
        answer.setDeletedDate(new Date());
        answer.setIsDeleted(true);
        answerRepository.save(answer);
        return true;
    }

}
