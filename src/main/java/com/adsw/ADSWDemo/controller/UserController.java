package com.adsw.ADSWDemo.controller;

import com.adsw.ADSWDemo.model.User;
import com.adsw.ADSWDemo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/users")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<User> getAllUsers(){
        return userService.getselectAllUsers();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{userId}"
    )
    public User getUserById(@PathVariable("userId") UUID userId){
        return userService.getUserById(userId);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertNewUser(@RequestBody User user){
        userService.persistinsertNewUser(UUID.randomUUID(), user);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{userID}"
    )
    public void updateUser(@PathVariable("userID") UUID userID, @RequestBody User user){
        userService.updateUserById(userID, user);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{userID}"
    )
    public void deleteUser(@PathVariable("userID") UUID userID){
        userService.deleteUserById(userID);
    }
}
