package com.example.spring_mvn.controller;

import com.example.spring_mvn.entity.UserRole;
import com.example.spring_mvn.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userrole")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("/add_role")
    public String addRole(@RequestBody UserRole userRole){
        userRoleService.addRole(userRole);
        return "Successfully Add User Role";
    }


}
