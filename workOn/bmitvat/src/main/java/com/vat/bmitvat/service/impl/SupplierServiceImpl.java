package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.entity.ItemsEntity;
import com.vat.bmitvat.entity.SupplierEntity;
import com.vat.bmitvat.mapper.ItemsMapper;
import com.vat.bmitvat.mapper.SupplierMapper;
import com.vat.bmitvat.model.ItemsModel;
import com.vat.bmitvat.model.SupplierModel;
import com.vat.bmitvat.repository.SupplierRepository;
import com.vat.bmitvat.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository){ this.supplierRepository=supplierRepository;
    }
    @Override
    public SupplierModel saveSingleSupplier(SupplierModel supplierModel){
        SupplierEntity supplierEntityReq= SupplierMapper.MAPPER.modelToEntity(supplierModel);
        SupplierEntity supplierEntityRes=supplierRepository.save(supplierEntityReq);
        return SupplierMapper.MAPPER.entityToModel(supplierEntityRes);

    }


    @Override
    public SupplierModel getSupplierById(Long id){
        Optional<SupplierEntity> supplierEntity = supplierRepository.findById(id);
        SupplierModel supplierModel = SupplierMapper.MAPPER.entityToModel(supplierEntity.get());
        return supplierModel;
    }




    @Override
    public SupplierModel updateSupplierById(SupplierModel supplierModel, Long id) {

        SupplierEntity supplierEntity = SupplierMapper.MAPPER.modelToEntity(supplierModel);
        return supplierRepository.findById(id)
                .map(topic -> {
                    topic.setSupplierName(supplierEntity.getSupplierName());
                    return SupplierMapper.MAPPER.entityToModel(supplierRepository.save(topic));
                })
                .orElseGet(() -> {
                    return SupplierMapper.MAPPER.entityToModel(supplierRepository.save(supplierEntity));
                });

    }

    @Override
    public List<SupplierModel> getAllSupplier() {
        List<SupplierEntity> supplierEntities = supplierRepository.findAll();
        List<SupplierModel> supplierModels = SupplierMapper.MAPPER.entityToModel(supplierEntities);
        return supplierModels;
    }


}