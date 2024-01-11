package com.vat.bmitvat.mapper;

import com.vat.bmitvat.entity.UnitsEntity;
import com.vat.bmitvat.entity.UserEntity;
import com.vat.bmitvat.model.SignUpRequest;
import com.vat.bmitvat.model.UnitsModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsersMapper {
    UsersMapper MAPPER= Mappers.getMapper(UsersMapper.class);
//    SignUpRequest entityToModel(UserEntity entity);
//    UserEntity modelToEntity(SignUpRequest model);
//
//    List<SignUpRequest>entityToModel(List<UserEntity> entities);
//
//    List<UserEntity> modelToEntity(List<SignUpRequest> models);
}
