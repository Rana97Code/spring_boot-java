package com.vat.bmitvat.mapper;

import com.vat.bmitvat.entity.SupplierEntity;
import com.vat.bmitvat.model.SupplierModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SupplierMapper {
    SupplierMapper MAPPER= Mappers.getMapper(SupplierMapper.class);
    SupplierModel entityToModel(SupplierEntity entity);
    SupplierEntity modelToEntity(SupplierModel model);

    List<SupplierModel> entityToModel(List<SupplierEntity> entities);

    List<SupplierEntity> modelToEntity(List<SupplierModel> models);
}
