package com.vat.bmitvat.mapper;

import com.vat.bmitvat.entity.ItemsEntity;
import com.vat.bmitvat.model.ItemsModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ItemsMapper {
    ItemsMapper MAPPER= Mappers.getMapper(ItemsMapper.class);
    ItemsModel entityToModel(ItemsEntity entity);
    ItemsEntity modelToEntity(ItemsModel model);

    List<ItemsModel> entityToModel(List<ItemsEntity> entities);

    List<ItemsEntity> modelToEntity(List<ItemsModel> models);

}