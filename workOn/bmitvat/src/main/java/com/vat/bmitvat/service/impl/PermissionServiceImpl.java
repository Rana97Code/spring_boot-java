package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.entity.PermissionEntity;
import com.vat.bmitvat.mapper.PermissionMapper;
import com.vat.bmitvat.model.PermissionModel;
import com.vat.bmitvat.repository.PermissionRepository;
import com.vat.bmitvat.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;
    @Autowired
    public PermissionServiceImpl(PermissionRepository permissionRepository){ this.permissionRepository=permissionRepository;
    }
    @Override
    public PermissionModel saveSinglePermission(PermissionModel permissionModel){
        PermissionEntity permissionEntityReq= PermissionMapper.MAPPER.modelToEntity(permissionModel);
        PermissionEntity permissionEntityRes=permissionRepository.save(permissionEntityReq);
        return PermissionMapper.MAPPER.entityToModel(permissionEntityRes);

    }
    }