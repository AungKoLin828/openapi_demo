package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.api.ApiApi;

import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.User;

@RestController
public class UsersApiImpl implements ApiApi{

    private final Map<Long, User> userDatabase = new HashMap<>();
    
    @Override
    public ResponseEntity<User> getUserById(Long id) {
        User user = userDatabase.get(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        long id = userDatabase.size() + 1L;
        user.setId(id);
        userDatabase.put(id, user);
        return ResponseEntity.status(201).body(user);
    } 
}
