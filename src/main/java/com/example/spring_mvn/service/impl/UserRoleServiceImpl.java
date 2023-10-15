package com.example.spring_mvn.service.impl;

import com.example.spring_mvn.entity.User_Role;
import com.example.spring_mvn.repository.UserRoleRepository;
import com.example.spring_mvn.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public void addRole(User_Role user_role){
        userRoleRepository.save(user_role);
    }
}
