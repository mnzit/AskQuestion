/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.askquestion.repositories;

import com.mnzit.askquestion.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dell
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

    @Query(value = "SELECT * FROM tbl_users u INNER JOIN tbl_user_profile up ON u.id=up.user_id WHERE u.username=? AND u.password=?;", nativeQuery = true)
    UserProfile checkUsernamePassword(String username, String password);

}
