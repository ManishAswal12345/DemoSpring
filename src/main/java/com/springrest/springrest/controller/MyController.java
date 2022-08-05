package com.springrest.springrest.controller;

import com.springrest.springrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springrest.springrest.entities.User;
import com.springrest.springrest.services.UserService;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private UserService userService;

    // get the users
    @GetMapping("/users")
    public List<User> getUsers(){
        return this.userService.getUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable String userId){
        return this.userService.getUser(Long.parseLong(userId));
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId){
        try{
            this.userService.deleteUser(Long.parseLong(userId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
