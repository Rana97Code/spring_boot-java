package com.vat.bmitvat.mapper;

import com.vat.bmitvat.entity.CpcCodeEntity;
import com.vat.bmitvat.model.CpcModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CpcMapper {
    CpcMapper MAPPER= Mappers.getMapper(CpcMapper.class);
    CpcModel entityToModel(CpcCodeEntity entity);
    CpcCodeEntity modelToEntity(CpcModel model);

    List<CpcModel> entityToModel(List<CpcCodeEntity> entities);

    List<CpcCodeEntity> modelToEntity(List<CpcModel> models);
}
