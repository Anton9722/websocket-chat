package com.websocketChat.websocketChat.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.websocketChat.websocketChat.models.User;
import com.websocketChat.websocketChat.service.UserService;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/user/create")
    public User createNewUser(@RequestBody User newUser) {
        return userService.createNewUser(newUser);
    }

}
