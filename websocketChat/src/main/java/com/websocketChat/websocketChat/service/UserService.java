package com.websocketChat.websocketChat.service;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.websocketChat.websocketChat.models.User;

@Service
public class UserService {
    
    private final MongoOperations mongoOperations;

    public UserService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public User createNewUser(User newUser) {
        mongoOperations.insert(newUser);
        return newUser;
    }

}
