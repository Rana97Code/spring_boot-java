package com.vat.bmitvat.service;

import com.vat.bmitvat.model.CostingModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CostingService {
    CostingModel saveSingleCosting(CostingModel costingModel);
    CostingModel getCostingById(Long id);

    List<CostingModel> getAllCosting();

    CostingModel updateCostingById(CostingModel costingModel, Long id);

    void excelCostingUpload(MultipartFile file);
}
