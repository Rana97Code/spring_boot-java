package com.vat.bmitvat.mapper;

import com.vat.bmitvat.entity.PermissionEntity;
import com.vat.bmitvat.model.PermissionModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PermissionMapper {
    PermissionMapper MAPPER= Mappers.getMapper(PermissionMapper.class);
    PermissionModel entityToModel(PermissionEntity entity);
    PermissionEntity modelToEntity(PermissionModel model);

    List<PermissionModel> entityToModel(List<PermissionEntity> entities);

    List<PermissionEntity> modelToEntity(List<PermissionModel> models);
}