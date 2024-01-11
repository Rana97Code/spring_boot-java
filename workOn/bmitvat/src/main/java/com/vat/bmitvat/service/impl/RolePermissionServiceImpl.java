package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.entity.RolePermissionEntity;
import com.vat.bmitvat.mapper.RolePermissionMapper;
import com.vat.bmitvat.model.RolePermissionModel;
import com.vat.bmitvat.repository.RolePermissionRepository;
import com.vat.bmitvat.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    private final RolePermissionRepository rolePermissionRepository;
    @Autowired
    public RolePermissionServiceImpl(RolePermissionRepository rolePermissionRepository){ this.rolePermissionRepository=rolePermissionRepository;
    }

    @Override
    public RolePermissionModel saveSingleRolePermission(RolePermissionModel rolePermissionModel) {
        RolePermissionEntity permissionEntityReq= RolePermissionMapper.MAPPER.modelToEntity(rolePermissionModel);
        RolePermissionEntity permissionEntityRes=rolePermissionRepository.save(permissionEntityReq);
        return RolePermissionMapper.MAPPER.entityToModel(permissionEntityRes);

    }
}
