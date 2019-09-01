/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.askquestion.repositories;

import com.mnzit.askquestion.models.Question;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dell
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query(value = "SELECT * FROM vw_questions", nativeQuery = true)
    List<Question> getActiveQuestions();
    
    @Query(value = "SELECT * FROM vw_questions WHERE created_by=?", nativeQuery = true)
    List<Question> getActiveQuestionsByProfileId(Integer createdBy);

}
