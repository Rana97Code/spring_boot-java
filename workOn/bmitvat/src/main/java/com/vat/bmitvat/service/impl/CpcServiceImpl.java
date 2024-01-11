package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.entity.CpcCodeEntity;
import com.vat.bmitvat.entity.CustomhouseEntity;
import com.vat.bmitvat.mapper.CpcMapper;
import com.vat.bmitvat.mapper.CustomhouseMapper;
import com.vat.bmitvat.model.CpcModel;
import com.vat.bmitvat.model.CustomhouseModel;
import com.vat.bmitvat.repository.CpcRepository;
import com.vat.bmitvat.service.CpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CpcServiceImpl implements CpcService {
    private final CpcRepository cpcRepository;

    @Autowired
    public CpcServiceImpl(CpcRepository cpcRepository){
        this.cpcRepository=cpcRepository;
    }
    @Override
    public CpcModel saveSingleCpc(CpcModel cpcModel){
        CpcCodeEntity cpcEntityReq= CpcMapper.MAPPER.modelToEntity(cpcModel);
        CpcCodeEntity cpcEntityRes=cpcRepository.save(cpcEntityReq);
        return CpcMapper.MAPPER.entityToModel(cpcEntityRes);

    }


    @Override
    public CpcModel getCpcById(Long id){
        Optional<CpcCodeEntity> cpcEntity = cpcRepository.findById(id);
        CpcModel cpcModel = CpcMapper.MAPPER.entityToModel(cpcEntity.get());
        return cpcModel;
    }

    @Override
    public List<CpcModel> getAllCpc() {
        return cpcRepository.findAll().stream().map(cpc -> {
            CpcModel cpcModel = new CpcModel();
            cpcModel.setId(cpc.getId());
            cpcModel.setCpcDescription(cpc.getCpcDescription());
            return cpcModel;
        }).collect(Collectors.toList());
    }

    @Override
    public CpcModel updateCpcById(CpcModel cpcModel, Long id) {
        CpcCodeEntity cpcCodeEntity = CpcMapper.MAPPER.modelToEntity(cpcModel);
        return cpcRepository.findById(id)
                .map(topic -> {
                    topic.setCpcDescription(cpcCodeEntity.getCpcDescription());
                    return CpcMapper.MAPPER.entityToModel(cpcRepository.save(topic));
                })
                .orElseGet(() -> {
                    return CpcMapper.MAPPER.entityToModel(cpcRepository.save(cpcCodeEntity));
                });
    }

    @Override
    public void excelCpcUpload(MultipartFile file) {
        if (ExelUploadService.isValidExcelFile(file)) {
            try {
                List<CpcModel> cpcModels = ExelUploadService.getCpcDataFromExcel(file.getInputStream());
                List<CpcCodeEntity> cpcCodeEntities = CpcMapper.MAPPER.modelToEntity(cpcModels);
                this.cpcRepository.saveAll(cpcCodeEntities);
            } catch (IOException e) {
                throw new IllegalArgumentException("This is not a valid Excel file !");
            }
        }
    }
}

