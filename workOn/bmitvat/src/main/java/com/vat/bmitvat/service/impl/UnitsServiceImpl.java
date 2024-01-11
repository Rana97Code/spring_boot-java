package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.entity.UnitsEntity;
import com.vat.bmitvat.mapper.UnitsMapper;
import com.vat.bmitvat.model.UnitsModel;
import com.vat.bmitvat.model.response.UnitsResponseModel;
import com.vat.bmitvat.repository.UnitsRepository;
import com.vat.bmitvat.service.UnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnitsServiceImpl implements UnitsService {
    private final UnitsRepository unitsRepository;

    @Autowired
    public UnitsServiceImpl(UnitsRepository unitsRepository){
        this.unitsRepository=unitsRepository;
    }
    @Override
    public UnitsModel saveSingleUnit(UnitsModel unitsModel){
        UnitsEntity unitsEntityReq= UnitsMapper.MAPPER.modelToEntity(unitsModel);
        UnitsEntity unitsEntityRes=unitsRepository.save(unitsEntityReq);
        return UnitsMapper.MAPPER.entityToModel(unitsEntityRes);

    }
    public List<UnitsModel> getAllUnit(){
        return unitsRepository.findAll().stream().map(unit -> {
            UnitsModel unitsModel = new UnitsModel();
            unitsModel.setId(unit.getId());
            unitsModel.setUnitName(unit.getUnitName());
            unitsModel.setAbbr(unit.getAbbr());
            return unitsModel;
        }).collect(Collectors.toList());
    }

    @Override
    public UnitsResponseModel getAllUnits(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC,"createdAt");
        Page<UnitsEntity> paginatedEntities = unitsRepository.findAll(pageable);
        List<UnitsEntity> unitsEntities = paginatedEntities.getContent();
        UnitsResponseModel unitsResponseModel = new UnitsResponseModel(UnitsMapper.MAPPER.entityToModel(unitsEntities), (int) paginatedEntities.getTotalElements(), page);
        return unitsResponseModel;
    }

    @Override
    public UnitsModel getUnitById(Long id){
        Optional<UnitsEntity> unitsEntity = unitsRepository.findById(id);
        UnitsModel unitsModel = UnitsMapper.MAPPER.entityToModel(unitsEntity.get());
        return unitsModel;
    }


    @Override
    public UnitsModel updateUnitById(UnitsModel unitsModel, Long id) {
        UnitsEntity unitsEntity = UnitsMapper.MAPPER.modelToEntity(unitsModel);
        return unitsRepository.findById(id)
                .map(topic -> {
                    topic.setUnitName(unitsEntity.getUnitName());
                    topic.setAbbr(unitsEntity.getAbbr());
                    topic.setStatus(unitsEntity.getStatus());
                    return UnitsMapper.MAPPER.entityToModel(unitsRepository.save(topic));
                })
                .orElseGet(() -> {
                    return UnitsMapper.MAPPER.entityToModel(unitsRepository.save(unitsEntity));
                });

    }
    @Override
    public String deleteUnitById(Long id) {
        unitsRepository.deleteById(id);
        return "Deleted Successfully the unit with id : " + id;

    }
    @Override
    public List<UnitsModel> findByAbbr(String abbr) {
        List<UnitsEntity> unitsEntity = unitsRepository.findByAbbr(abbr);
        return UnitsMapper.MAPPER.entityToModel(unitsEntity);
    }
    @Override
    public List<UnitsModel> searchByUnitName(String unit) {
        List<UnitsEntity> unitsEntity = unitsRepository.findByUnitName(unit);
        return UnitsMapper.MAPPER.entityToModel(unitsEntity);
    }
    @Override
    public void excelUnitUpload(MultipartFile file) {

        if (ExelUploadService.isValidExcelFile(file)) {
            try {
//                System.out.println(file.getSize());

                List<UnitsModel> units = ExelUploadService.getUnitsDataFromExcel(file.getInputStream());
                List<UnitsEntity> unitsEntities = UnitsMapper.MAPPER.modelToEntity(units);
//                System.out.println(unitsEntities);
                this.unitsRepository.saveAll(unitsEntities);
            } catch (IOException e) {
                throw new IllegalArgumentException("This is not a valid Excel file !");
            }
        }
    }


}