package com.vat.bmitvat.service;

import com.vat.bmitvat.entity.UserEntity;
import com.vat.bmitvat.model.SignInRequest;
import com.vat.bmitvat.model.SignUpRequest;
import com.vat.bmitvat.model.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String addUser(SignUpRequest signUpRequest);
    UserDetailsService userDetailsService();

    String usersignin(SignInRequest signInRequest);

    List<UserModel> getAllUsers();

    Optional<UserEntity> getUserById(Long id);
    String updateUserById(SignUpRequest signUpRequest, Long id);
}
