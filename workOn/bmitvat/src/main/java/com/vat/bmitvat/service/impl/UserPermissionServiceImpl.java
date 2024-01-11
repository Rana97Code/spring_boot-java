package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.entity.UserPermissionEntity;
import com.vat.bmitvat.mapper.UserPermissionMapper;
import com.vat.bmitvat.model.UserPermissionModel;
import com.vat.bmitvat.repository.UserPermissionRepository;
import com.vat.bmitvat.service.UserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPermissionServiceImpl implements UserPermissionService {
    private final UserPermissionRepository userPermissionRepository;
    @Autowired
    public UserPermissionServiceImpl(UserPermissionRepository userPermissionRepository){ this.userPermissionRepository=userPermissionRepository;
    }
    @Override
    public UserPermissionModel saveSingleUserPermission(UserPermissionModel userPermissionModel){
        UserPermissionEntity userPermissionEntityReq= UserPermissionMapper.MAPPER.modelToEntity(userPermissionModel);
        UserPermissionEntity  userPermissionEntityRes=userPermissionRepository.save(userPermissionEntityReq);
        return UserPermissionMapper.MAPPER.entityToModel(userPermissionEntityRes);

    }

}