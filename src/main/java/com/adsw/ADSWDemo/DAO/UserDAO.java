package com.adsw.ADSWDemo.DAO;

import com.adsw.ADSWDemo.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDAO {

    //Definiciones de CRUD

    int insertNewUser(UUID userId, User user);

    User selectUserById(UUID userId);

    List<User> selectAllUsers();

    int updateUserById(UUID userId, User userUpdate);

    int deleteUserById(UUID userId);
}
