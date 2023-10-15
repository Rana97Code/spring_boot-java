package com.example.spring_mvn.service.impl;

import com.example.spring_mvn.dto.AccessDTO;
import com.example.spring_mvn.dto.UserAccessDTO;
import com.example.spring_mvn.dto.UserDTO;
import com.example.spring_mvn.entity.User;
import com.example.spring_mvn.repository.UserRepository;
import com.example.spring_mvn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void addUser(User user) {
        userRepository.save(user);

    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(Integer id) {
        User oneuser = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user Id"+id));
        return oneuser;
    }

    @Override
    public void updateUser(Integer id, User user) {
        //check weather the user is in database or not
        userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid User Id"+id));

        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        //check weather the user is in database or not
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User Id"+id));

        userRepository.delete(user);

    }

    @Override
    public void updateName(Integer id, UserDTO userDTO) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User Id : "+id));
        user.setName(userDTO.getName());

        userRepository.save(user);
    }

    @Override
    public User CreateUserAccess(AccessDTO accessDTO) {
        userRepository.save(accessDTO.getUser());
        return null;
    }

    @Override
    public List<UserAccessDTO> getUserAccess() {
        return userRepository.getUserAccess();
    }


}
