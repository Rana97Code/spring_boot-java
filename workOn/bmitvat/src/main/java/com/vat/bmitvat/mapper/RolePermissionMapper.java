package com.vat.bmitvat.mapper;

import com.vat.bmitvat.entity.RolePermissionEntity;
import com.vat.bmitvat.model.RolePermissionModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RolePermissionMapper {
    RolePermissionMapper MAPPER= Mappers.getMapper(RolePermissionMapper.class);
    RolePermissionModel entityToModel(RolePermissionEntity entity);
    RolePermissionEntity modelToEntity(RolePermissionModel model);

    List<RolePermissionModel> entityToModel(List<RolePermissionEntity> entities);

    List<RolePermissionEntity> modelToEntity(List<RolePermissionModel> models);
}
