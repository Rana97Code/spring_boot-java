package com.vat.bmitvat.mapper;

import com.vat.bmitvat.entity.HsCodeEntity;
import com.vat.bmitvat.model.HsCodeModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HsCodeMapper {
    HsCodeMapper MAPPER= Mappers.getMapper(HsCodeMapper.class);
    HsCodeModel entityToModel(HsCodeEntity entity);
    HsCodeEntity modelToEntity(HsCodeModel model);

    List<HsCodeModel> entityToModel(List<HsCodeEntity> entities);

    List<HsCodeEntity> modelToEntity(List<HsCodeModel> models);
}
