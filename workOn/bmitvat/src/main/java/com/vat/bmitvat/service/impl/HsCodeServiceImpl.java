package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.entity.HsCodeEntity;
import com.vat.bmitvat.mapper.HsCodeMapper;
import com.vat.bmitvat.model.HsCodeModel;
import com.vat.bmitvat.repository.HsCodeRepository;
import com.vat.bmitvat.service.HsCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HsCodeServiceImpl implements HsCodeService {
    private final HsCodeRepository hsCodeRepository;

    @Autowired
    public HsCodeServiceImpl(HsCodeRepository hsCodeRepository) {
        this.hsCodeRepository = hsCodeRepository;
    }

    @Override
    public List<HsCodeModel> getAllHsCode() {
        List<HsCodeEntity> hsCodeEntities = hsCodeRepository.findAll();
        List<HsCodeModel> hsCodeModels = HsCodeMapper.MAPPER.entityToModel(hsCodeEntities);
        return hsCodeModels;

    }
}
