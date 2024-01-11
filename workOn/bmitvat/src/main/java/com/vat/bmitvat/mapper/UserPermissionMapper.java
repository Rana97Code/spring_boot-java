package com.vat.bmitvat.mapper;

import com.vat.bmitvat.entity.UserPermissionEntity;
import com.vat.bmitvat.model.UserPermissionModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserPermissionMapper {

    UserPermissionMapper MAPPER= Mappers.getMapper(UserPermissionMapper.class);
    UserPermissionModel entityToModel(UserPermissionEntity entity);
    UserPermissionEntity modelToEntity(UserPermissionModel model);

    List<UserPermissionModel> entityToModel(List<UserPermissionEntity> entities);

    List<UserPermissionEntity> modelToEntity(List<UserPermissionModel> models);
}