package com.vat.bmitvat.mapper;

import com.vat.bmitvat.entity.RoleEntity;
import com.vat.bmitvat.model.RoleModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleMapper MAPPER= Mappers.getMapper(RoleMapper.class);
    RoleModel entityToModel(RoleEntity entity);
    RoleEntity modelToEntity(RoleModel model);

    List<RoleModel> entityToModel(List<RoleEntity> entities);

    List<RoleEntity> modelToEntity(List<RoleModel> models);
}
