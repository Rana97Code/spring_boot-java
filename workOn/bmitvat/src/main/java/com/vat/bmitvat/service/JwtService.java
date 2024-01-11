package com.vat.bmitvat.service;

import com.vat.bmitvat.model.TokenModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {
    String extractUserName(String token);

    String generateToken(TokenModel tokenModel);
    //
    boolean isTokenValid(String token, UserDetails userDetails);
}
