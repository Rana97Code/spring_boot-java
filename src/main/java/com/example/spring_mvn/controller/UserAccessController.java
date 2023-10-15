package com.example.spring_mvn.controller;

import com.example.spring_mvn.entity.User_Access;
import com.example.spring_mvn.service.UserAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/useraccess")
public class UserAccessController {

    @Autowired
    private UserAccessService userAccessService;

    @PostMapping("/set_access")
    public String setAccess(@RequestBody User_Access userAccess){
        userAccessService.setAccess(userAccess);
        return "Access Set-Up Successfull";
    }
}
