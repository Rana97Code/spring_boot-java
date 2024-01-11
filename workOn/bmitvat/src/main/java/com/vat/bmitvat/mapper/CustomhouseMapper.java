package com.vat.bmitvat.mapper;

import com.vat.bmitvat.entity.CustomhouseEntity;
import com.vat.bmitvat.model.CustomhouseModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomhouseMapper {
    CustomhouseMapper MAPPER= Mappers.getMapper(CustomhouseMapper.class);
    CustomhouseModel entityToModel(CustomhouseEntity entity);
    CustomhouseEntity modelToEntity(CustomhouseModel model);

    List<CustomhouseModel> entityToModel(List<CustomhouseEntity> entities);

    List<CustomhouseEntity> modelToEntity(List<CustomhouseModel> models);
}

