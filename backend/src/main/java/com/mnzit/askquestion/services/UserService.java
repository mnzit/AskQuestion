/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.askquestion.services;

import com.mnzit.askquestion.dto.UserDTO;
import com.mnzit.askquestion.models.UserProfile;
import com.mnzit.askquestion.repositories.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class UserService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile login(UserDTO userDTO) {
        UserProfile profile = null;
        profile = userProfileRepository.checkUsernamePassword(userDTO.getUsername(), userDTO.getPassword());
        if (profile == null) {
            throw new RuntimeException("User not found");
        }
        return profile;
    }
}
