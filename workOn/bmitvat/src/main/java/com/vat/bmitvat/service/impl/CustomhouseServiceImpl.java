package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.entity.CostingEntity;
import com.vat.bmitvat.entity.CustomhouseEntity;
import com.vat.bmitvat.mapper.CostingMapper;
import com.vat.bmitvat.mapper.CustomhouseMapper;
import com.vat.bmitvat.model.CostingModel;
import com.vat.bmitvat.model.CustomhouseModel;
import com.vat.bmitvat.repository.CustomhouseRepository;
import com.vat.bmitvat.service.CustomhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomhouseServiceImpl implements CustomhouseService {
    private final CustomhouseRepository customhouseRepository;

    @Autowired
    public CustomhouseServiceImpl(CustomhouseRepository customhouseRepository){
        this.customhouseRepository=customhouseRepository;
    }
    @Override
    public CustomhouseModel saveSingleCustomHouse(CustomhouseModel customhouseModel){

        CustomhouseEntity customhouseEntityReq= CustomhouseMapper.MAPPER.modelToEntity(customhouseModel);
        CustomhouseEntity customhouseEntityRes=customhouseRepository.save(customhouseEntityReq);
        return CustomhouseMapper.MAPPER.entityToModel(customhouseEntityRes);

    }

    @Override
    public CustomhouseModel getCustomHouseById(Long id){
        Optional<CustomhouseEntity> customhouseEntity = customhouseRepository.findById(id);
        CustomhouseModel customhouseModel = CustomhouseMapper.MAPPER.entityToModel(customhouseEntity.get());
        return customhouseModel;
    }

    @Override
    public List<CustomhouseModel> getAllCustom() {
        return customhouseRepository.findAll().stream().map(custom -> {
            CustomhouseModel customhouseModel = new CustomhouseModel();
            customhouseModel.setId(custom.getId());
            customhouseModel.setHouseName(custom.getHouseName());
            customhouseModel.setHouseCode(custom.getHouseCode());
            customhouseModel.setHouseAddress(custom.getHouseAddress());
            return customhouseModel;
        }).collect(Collectors.toList());

    }

    @Override
    public CustomhouseModel updateCustomHouseById(CustomhouseModel customhouseModel, Long id) {
        CustomhouseEntity customhouseEntity = CustomhouseMapper.MAPPER.modelToEntity(customhouseModel);
        return customhouseRepository.findById(id)
                .map(topic -> {
                    topic.setHouseName(customhouseEntity.getHouseName());
                    topic.setHouseCode(customhouseEntity.getHouseCode());
                    topic.setHouseAddress(customhouseEntity.getHouseAddress());
                    return CustomhouseMapper.MAPPER.entityToModel(customhouseRepository.save(topic));
                })
                .orElseGet(() -> {
                    return CustomhouseMapper.MAPPER.entityToModel(customhouseRepository.save(customhouseEntity));
                });

    }

    @Override
    public void excelCustomUpload(MultipartFile file) {
        if (ExelUploadService.isValidExcelFile(file)) {
            try {
                List<CustomhouseModel> customhouseModels = ExelUploadService.getCustomDataFromExcel(file.getInputStream());
                List<CustomhouseEntity> customhouseEntities = CustomhouseMapper.MAPPER.modelToEntity(customhouseModels);
                this.customhouseRepository.saveAll(customhouseEntities);
            } catch (IOException e) {
                throw new IllegalArgumentException("This is not a valid Excel file !");
            }
        }
    }
}
