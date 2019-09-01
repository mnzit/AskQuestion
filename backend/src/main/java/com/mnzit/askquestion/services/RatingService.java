/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.askquestion.services;

import com.mnzit.askquestion.dto.RatingDTO;
import com.mnzit.askquestion.models.Rating;
import com.mnzit.askquestion.repositories.AnswerRepository;
import com.mnzit.askquestion.repositories.RatingRepository;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class RatingService implements GenericService<Rating, RatingDTO> {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Rating save(RatingDTO dto) {
        if (!answerRepository.existsById(dto.getAnswerId())) {
            throw new RuntimeException("Answer " + dto.getAnswerId() + " not found");
        }
        return ratingRepository.save(mapper.map(dto, Rating.class));
    }

    @Override
    public List<Rating> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rating getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rating update(RatingDTO dto) {
        if (((!answerRepository.existsById(dto.getAnswerId()) && (!ratingRepository.existsById(dto.getId()))))) {
            throw new RuntimeException("Values not matched! Cannot UPDATE");
        }
        return ratingRepository.save(mapper.map(dto, Rating.class));
    }

    @Override
    public Boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
