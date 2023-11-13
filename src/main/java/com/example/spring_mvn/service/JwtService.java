package com.example.spring_mvn.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {
    String extractUserName(String token);

    String generateToken(String userDetails);
    //
    boolean isTokenValid(String token, UserDetails userDetails);
}
