package com.springrest.springrest.services;

import org.springframework.stereotype.Service;
import com.springrest.springrest.entities.User;
import com.springrest.springrest.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService{

    List<User> list;

    public UserServiceImpl(){
        list = new ArrayList<>();
        list.add(new User(11, "Manish", "manish@gmail.com"));
        list.add(new User(12, "John", "john@gmail.com"));
    }

    @Override
    public List<User> getUsers(){
        return list;
    }

    @Override
    public User getUser(long userId) {
        User u = null;
        for(User user:list){
            if(user.getId() == userId){
                u = user;
                break;
            }

        }
        return u;
    }

    @Override
    public User addUser(User user) {
        list.add(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        list.forEach(e -> {
            if(e.getId() == user.getId()){
                e.setName(user.getName());
                e.setEmail(user.getEmail());
            }
        });
        return user;
    }

    @Override
    public void deleteUser(long parseLong) {
        list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
    }
}
