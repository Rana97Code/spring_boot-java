package com.vat.bmitvat.mapper;

import com.vat.bmitvat.entity.CostingEntity;
import com.vat.bmitvat.model.CostingModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CostingMapper {
    CostingMapper MAPPER= Mappers.getMapper(CostingMapper.class);
    CostingModel entityToModel(CostingEntity entity);
    CostingEntity modelToEntity(CostingModel model);

    List<CostingModel> entityToModel(List<CostingEntity> entities);

    List<CostingEntity> modelToEntity(List<CostingModel> models);
}