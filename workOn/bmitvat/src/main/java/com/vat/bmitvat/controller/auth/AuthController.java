package com.vat.bmitvat.controller.auth;

import com.vat.bmitvat.model.SignInRequest;
import com.vat.bmitvat.service.JwtService;
import com.vat.bmitvat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/auth")
    public String usersignin(@RequestBody SignInRequest signInRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));
        if (authentication.isAuthenticated()) {
//            System.out.println(signInRequest);
            return userService.usersignin(signInRequest);
        }else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
