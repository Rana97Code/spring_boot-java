package com.vat.bmitvat.mapper;

import com.vat.bmitvat.entity.UserRoleEntity;
import com.vat.bmitvat.model.UserRoleModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserRoleMapper {
    UserRoleMapper MAPPER= Mappers.getMapper(UserRoleMapper.class);
    UserRoleModel entityToModel(UserRoleEntity entity);
    UserRoleEntity modelToEntity(UserRoleModel model);

    List<UserRoleModel> entityToModel(List<UserRoleEntity> entities);

    List<UserRoleEntity> modelToEntity(List<UserRoleModel> models);
}
