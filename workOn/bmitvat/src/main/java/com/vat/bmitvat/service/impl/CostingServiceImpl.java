package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.entity.CostingEntity;
import com.vat.bmitvat.entity.UnitsEntity;
import com.vat.bmitvat.mapper.CostingMapper;
import com.vat.bmitvat.mapper.UnitsMapper;
import com.vat.bmitvat.model.CostingModel;
import com.vat.bmitvat.model.UnitsModel;
import com.vat.bmitvat.repository.CostingRepository;
import com.vat.bmitvat.service.CostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CostingServiceImpl implements CostingService {
    private final CostingRepository costingRepository;

    @Autowired
    public CostingServiceImpl(CostingRepository costingRepository){
        this.costingRepository=costingRepository;
    }
    @Override
    public CostingModel saveSingleCosting(CostingModel costingModel){
        CostingEntity costingEntityReq= CostingMapper.MAPPER.modelToEntity(costingModel);
        CostingEntity costingEntityRes=costingRepository.save(costingEntityReq);
        return CostingMapper.MAPPER.entityToModel(costingEntityRes);

    }

    @Override
    public CostingModel getCostingById(Long id){
        Optional<CostingEntity> costingEntity = costingRepository.findById(id);
        CostingModel costingModel = CostingMapper.MAPPER.entityToModel(costingEntity.get());
        return costingModel;
    }

    @Override
    public List<CostingModel> getAllCosting() {
        return costingRepository.findAll().stream().map(costing -> {
            CostingModel costingModel = new CostingModel();
            costingModel.setId(costing.getId());
            costingModel.setCostingName(costing.getCostingName());
            costingModel.setCostingType(costing.getCostingType());
            return costingModel;
        }).collect(Collectors.toList());
    }

    @Override
    public CostingModel updateCostingById(CostingModel costingModel, Long id) {
            CostingEntity costingEntity = CostingMapper.MAPPER.modelToEntity(costingModel);
            return costingRepository.findById(id)
                    .map(topic -> {
                        topic.setCostingName(costingEntity.getCostingName());
                        topic.setCostingType(costingEntity.getCostingType());
                        return CostingMapper.MAPPER.entityToModel(costingRepository.save(topic));
                    })
                    .orElseGet(() -> {
                        return CostingMapper.MAPPER.entityToModel(costingRepository.save(costingEntity));
                    });

        }

    @Override
    public void excelCostingUpload(MultipartFile file) {
        if (ExelUploadService.isValidExcelFile(file)) {
            try {
                List<CostingModel> costingModels = ExelUploadService.getCostingDataFromExcel(file.getInputStream());
                List<CostingEntity> costingEntities = CostingMapper.MAPPER.modelToEntity(costingModels);
                this.costingRepository.saveAll(costingEntities);
            } catch (IOException e) {
                throw new IllegalArgumentException("This is not a valid Excel file !");
            }
        }
    }

}
