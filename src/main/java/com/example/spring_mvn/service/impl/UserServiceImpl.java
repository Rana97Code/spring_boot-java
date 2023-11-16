package com.example.spring_mvn.service.impl;

import com.example.spring_mvn.dto.*;
import com.example.spring_mvn.entity.User;
import com.example.spring_mvn.mapper.UsersMapper;
import com.example.spring_mvn.repository.UserRepository;
import com.example.spring_mvn.service.JwtService;
import com.example.spring_mvn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;


    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return (UserDetails) userRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public String addUser(SignUpRequest signUpRequest) {
        User user= UsersMapper.MAPPER.modelToEntity(signUpRequest);
        userRepository.save(user);
        return "Successfully Insert";
    }


//    @Override
//    public JwtAuthResponse signup(SignUpRequest request) {
//        var user = UserEntity.builder()
//                .userName(request.getUserName())
//                .userEmail(request.getUserEmail())
//                .userPassword(passwordEncoder.encode(request.getUserPassword()));
//        System.out.println(user);
////        userRepository.save(user);
//        var jwt = jwtService.generateToken((UserDetails) user);
//        return JwtAuthResponse.builder().token(jwt).build();
//    }

    @Override
    public String usersignin(SignInRequest signInRequest) {

        UserRoleModel userRoleModel = userRepository.getUserRole(signInRequest.getUsername());
//        System.out.println(userRoleModel);

        var user = userRepository.findByUsername(signInRequest.getUsername());
        System.out.println(user.stream().count());
        var uu = user.stream().count();
        if(isNotEmpty(uu)){
            return jwtService.generateToken(userRoleModel);
        } else {
            throw new UsernameNotFoundException("Invalid Email OR Password !");
        }

    }


//    @Override
//    public void addUser(User user) {
//        userRepository.save(user);
//
//    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(Long id) {
        User oneuser = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user Id"+id));
        return oneuser;
    }

    @Override
    public void updateUser(Long id, User user) {
        //check weather the user is in database or not
        userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid User Id"+id));

        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        //check weather the user is in database or not
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User Id"+id));

        userRepository.delete(user);

    }

    @Override
    public void updateName(Long id, UserDTO userDTO) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User Id : "+id));
        user.setUsername(userDTO.getName());

        userRepository.save(user);
    }




}
