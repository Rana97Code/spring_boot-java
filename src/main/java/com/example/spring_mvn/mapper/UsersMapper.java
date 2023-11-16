package com.example.spring_mvn.mapper;

import com.example.spring_mvn.dto.SignUpRequest;
import com.example.spring_mvn.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsersMapper {

    UsersMapper MAPPER= Mappers.getMapper(UsersMapper.class);
    SignUpRequest entityToModel(User entity);
    User modelToEntity(SignUpRequest model);

    List<SignUpRequest> entityToModel(List<User> entities);

    List<User> modelToEntity(List<SignUpRequest> models);
}
