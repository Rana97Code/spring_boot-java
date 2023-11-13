package com.example.spring_mvn.controller;

import com.example.spring_mvn.dto.SignInRequest;
import com.example.spring_mvn.dto.SignUpRequest;
import com.example.spring_mvn.service.JwtService;
import com.example.spring_mvn.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
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


    @GetMapping("/welcome")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    //    @PostMapping("/sign_up")
//    public String addUser(@RequestBody UserEntity userEntity) {
//        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
//        return userService.addUser(userEntity);
//    }
    @PostMapping("/register")
    public String addUser(@RequestBody SignUpRequest signUpRequest) {
//        System.out.println(signUpRequest);
        signUpRequest.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        return userService.addUser(signUpRequest);
    }

    @PostMapping("/login")
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