package com.example.spring_mvn.controller;

import com.example.spring_mvn.entity.Roles;
import com.example.spring_mvn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/add_role")
    public String addrole(@RequestBody Roles roles){
        roleService.addrole(roles);
        return "Access Set-Up Successfull";
    }
}
