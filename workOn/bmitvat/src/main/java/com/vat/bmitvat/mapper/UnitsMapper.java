package com.vat.bmitvat.mapper;

import com.vat.bmitvat.entity.UnitsEntity;
import com.vat.bmitvat.model.UnitsModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UnitsMapper {
    UnitsMapper MAPPER= Mappers.getMapper(UnitsMapper.class);
    UnitsModel entityToModel(UnitsEntity entity);
    UnitsEntity modelToEntity(UnitsModel model);

    List<UnitsModel> entityToModel(List<UnitsEntity> entities);

    List<UnitsEntity> modelToEntity(List<UnitsModel> models);
}
