package com.example.spring_mvn.service;

import com.example.spring_mvn.dto.*;
import com.example.spring_mvn.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    //    for add Auth start

    String addUser(SignUpRequest signUpRequest);
    UserDetailsService userDetailsService();

    String usersignin(SignInRequest signInRequest);

    //    for add Auth End



//    void addUser(User user);

    //for get user
    List<User> getUsers();

    //for getting single user
    User getOne(Long id);

    //for update user
    void updateUser(Long id, User user);

    void deleteUser(Long id);

    void updateName(Long id, UserDTO userDTO);




}
