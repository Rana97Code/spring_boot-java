package com.example.spring_mvn.service;

import com.example.spring_mvn.dto.UserDTO;
import com.example.spring_mvn.entity.User;

import java.util.List;

public interface UserService {
    //    for add user
    void addUser(User user);

    //for get user
    List<User> getUsers();

    //for getting single user
    User getOne(Integer id);

    //for update user
    void updateUser(Integer id, User user);

    void deleteUser(Integer id);

    void updateName(Integer id, UserDTO userDTO);
}
