package com.example.spring_mvn.service.impl;

import com.example.spring_mvn.entity.Roles;
import com.example.spring_mvn.repository.RoleRepository;
import com.example.spring_mvn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void addrole(Roles roles) {
        roleRepository.save(roles);
    }
}
