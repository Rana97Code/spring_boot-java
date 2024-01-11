package com.vat.bmitvat.mapper.procurement;


import com.vat.bmitvat.entity.procurement.PurchaseItemEntity;
import com.vat.bmitvat.model.procurement.PurchaseItemModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface PurchaseItemMapper {
    PurchaseItemMapper MAPPER= Mappers.getMapper(PurchaseItemMapper.class);
    PurchaseItemModel entityToModel(PurchaseItemEntity entity);
    PurchaseItemEntity modelToEntity(PurchaseItemModel model);
    List<PurchaseItemModel> entityToModel(List<PurchaseItemEntity> entities);
    List<PurchaseItemEntity> modelToEntity(List<PurchaseItemModel> models);
}
