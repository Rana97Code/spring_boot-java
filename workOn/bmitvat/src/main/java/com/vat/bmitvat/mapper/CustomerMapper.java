package com.vat.bmitvat.mapper;

import com.vat.bmitvat.entity.CustomerEntity;
import com.vat.bmitvat.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerMapper MAPPER= Mappers.getMapper(CustomerMapper.class);
    CustomerModel entityToModel(CustomerEntity entity);
    CustomerEntity modelToEntity(CustomerModel model);

    List<CustomerModel> entityToModel(List<CustomerEntity> entities);

    List<CustomerEntity> modelToEntity(List<CustomerModel> models);
}
