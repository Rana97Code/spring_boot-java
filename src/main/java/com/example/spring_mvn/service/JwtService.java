package com.example.spring_mvn.service;

import com.example.spring_mvn.dto.UserRoleModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {
    String extractUserName(String token);

    String generateToken(UserRoleModel userRoleModel);
    //
    boolean isTokenValid(String token, UserDetails userDetails);
}
