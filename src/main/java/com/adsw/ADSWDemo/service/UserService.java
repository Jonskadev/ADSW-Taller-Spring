package com.adsw.ADSWDemo.service;

import com.adsw.ADSWDemo.DAO.UserDAO;
import com.adsw.ADSWDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class UserService {

    private final UserDAO userDAO;

    @Autowired

    public UserService(@Qualifier("fakeUserDAO") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public int persistinsertNewUser(UUID userId, User user){
        UUID userUUID = userId == null ? UUID.randomUUID() : userId;
        user.setId(userId);
        return userDAO.insertNewUser(userUUID, user);
    }

    public User getUserById(UUID userId){

        return userDAO.selectUserById(userId);
    }

    public List<User> getselectAllUsers(){

        return userDAO.selectAllUsers();
    }

    public int updateUserById(UUID userId, User userUpdate){

        return userDAO.updateUserById(userId, userUpdate);
    }

    public int deleteUserById(UUID userId){

        return userDAO.deleteUserById(userId);
    }
}
