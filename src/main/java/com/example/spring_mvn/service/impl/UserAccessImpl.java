package com.example.spring_mvn.service.impl;

import com.example.spring_mvn.entity.User_Access;
import com.example.spring_mvn.repository.UserAccessRepository;
import com.example.spring_mvn.service.UserAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccessImpl implements UserAccessService {

    @Autowired
    private UserAccessRepository userAccessRepository;

    @Override
    public void setAccess(User_Access userAccess) {
        userAccessRepository.save(userAccess);
    }
}
