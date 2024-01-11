package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.entity.RoleEntity;
import com.vat.bmitvat.mapper.RoleMapper;
import com.vat.bmitvat.model.RoleModel;
import com.vat.bmitvat.repository.RoleRepository;
import com.vat.bmitvat.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository){ this.roleRepository=roleRepository;
    }
    @Override
    public RoleModel saveSingleRole(RoleModel roleModel){
        RoleEntity roleEntityReq= RoleMapper.MAPPER.modelToEntity(roleModel);
        RoleEntity roleEntityRes=roleRepository.save(roleEntityReq);
        return RoleMapper.MAPPER.entityToModel(roleEntityRes);

    }
    }