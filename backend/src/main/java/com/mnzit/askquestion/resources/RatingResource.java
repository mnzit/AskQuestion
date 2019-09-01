/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.askquestion.resources;

import com.mnzit.askquestion.dto.RatingDTO;
import com.mnzit.askquestion.models.Rating;
import com.mnzit.askquestion.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class RatingResource {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/answer/rating/save")
    public ResponseEntity<Rating> saveRating(@RequestBody RatingDTO ratingDTO) {
        return new ResponseEntity<>(ratingService.save(ratingDTO), HttpStatus.OK);
    }

    @PutMapping("/answer/rating/update")
    public ResponseEntity<Rating> updateRating(@RequestBody RatingDTO ratingDTO) {
        return new ResponseEntity<>(ratingService.update(ratingDTO), HttpStatus.OK);
    }
}
