package com.vat.bmitvat.mapper.procurement;


import com.vat.bmitvat.entity.procurement.PurchaseEntity;
import com.vat.bmitvat.model.procurement.PurchaseModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface PurchaseMapper {
    PurchaseMapper MAPPER= Mappers.getMapper(PurchaseMapper.class);
    PurchaseModel entityToModel(PurchaseEntity entity);
    PurchaseEntity modelToEntity(PurchaseModel model);
    List<PurchaseModel> entityToModel(List<PurchaseEntity> entities);
    List<PurchaseEntity> modelToEntity(List<PurchaseModel> models);
}
