package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.entity.UserRoleEntity;
import com.vat.bmitvat.mapper.UserRoleMapper;
import com.vat.bmitvat.model.UserRoleModel;
import com.vat.bmitvat.repository.UserRoleRepository;
import com.vat.bmitvat.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository){
        this.userRoleRepository=userRoleRepository;
    }
    @Override
    public UserRoleModel saveSingleUserRole(UserRoleModel userRoleModel){
        UserRoleEntity userRoleEntityReq= UserRoleMapper.MAPPER.modelToEntity(userRoleModel);
        UserRoleEntity userRoleEntityRes=userRoleRepository.save(userRoleEntityReq);
        return UserRoleMapper.MAPPER.entityToModel(userRoleEntityRes);

    }
}