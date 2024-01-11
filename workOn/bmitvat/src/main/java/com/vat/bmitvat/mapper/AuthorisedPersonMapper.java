package com.vat.bmitvat.mapper;

import com.vat.bmitvat.entity.AuthorisedPersonEntity;
import com.vat.bmitvat.model.AuthorisedPersonModel;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface AuthorisedPersonMapper {
    AuthorisedPersonMapper MAPPER= Mappers.getMapper(AuthorisedPersonMapper.class);
    AuthorisedPersonModel entityToModel(AuthorisedPersonEntity entity);
    AuthorisedPersonEntity modelToEntity(AuthorisedPersonModel model);
    List<AuthorisedPersonModel> entityToModel();
    List<AuthorisedPersonEntity> modelToEntity(List<AuthorisedPersonModel> models);

}
