package com.example.spring_mvn.mapper;

import com.example.spring_mvn.dto.UnitDTO;
import com.example.spring_mvn.entity.Unit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UnitMapper {
    UnitMapper MAPPER= Mappers.getMapper(UnitMapper.class);
    UnitDTO entityToDto(Unit entity);
    Unit dtoToEntity(UnitDTO dto);

    List<UnitDTO> entityToDto(List<Unit> entities);
    List<Unit> dtoToEntity(List<UnitDTO> dtos);
}
