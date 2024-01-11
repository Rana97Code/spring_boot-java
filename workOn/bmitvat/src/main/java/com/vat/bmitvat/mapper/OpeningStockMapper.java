package com.vat.bmitvat.mapper;

import com.vat.bmitvat.entity.ItemsEntity;
import com.vat.bmitvat.entity.OpeningStockEntity;
import com.vat.bmitvat.model.ItemsModel;
import com.vat.bmitvat.model.OpeningAddModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OpeningStockMapper {
    OpeningStockMapper MAPPER= Mappers.getMapper(OpeningStockMapper.class);
    OpeningAddModel entityToModel(OpeningStockEntity entity);
    OpeningStockEntity modelToEntity(OpeningAddModel model);

    List<OpeningAddModel> entityToModel(List<OpeningStockEntity> entities);

    List<OpeningStockEntity> modelToEntity(List<OpeningAddModel> models);
}
