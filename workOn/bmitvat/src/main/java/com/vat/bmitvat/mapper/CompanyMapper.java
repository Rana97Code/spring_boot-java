package com.vat.bmitvat.mapper;

import com.vat.bmitvat.entity.CompanyEntity;
import com.vat.bmitvat.model.CompanyModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CompanyMapper {
    CompanyMapper MAPPER= Mappers.getMapper(CompanyMapper.class);
//    CompanyModel entityToModel(CompanyEntity entity);
//    CompanyEntity modelToEntity(CompanyModel model);
//
//    List<CompanyModel> entityToModel(List<CompanyEntity> entities);
//
//    List<CompanyEntity> modelToEntity(List<CompanyModel> models);
}
