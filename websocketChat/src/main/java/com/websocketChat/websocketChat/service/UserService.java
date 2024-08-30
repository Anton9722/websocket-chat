package com.websocketChat.websocketChat.service;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

    public Boolean checkLogin(User userToCheckLogin) {
        Query query = new Query();
        query.addCriteria(new Criteria().andOperator(
            Criteria.where("username").is(userToCheckLogin.getUsername()),
            Criteria.where("password").is(userToCheckLogin.getPassword())
        ));

        User user = mongoOperations.findOne(query, User.class);
        if (user == null) {
            return false;
        }
        else {
            return true;
        }
    }

}
