package com.vat.bmitvat.service;

import com.vat.bmitvat.model.CpcModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CpcService {
    CpcModel saveSingleCpc(CpcModel cpcModel);
    CpcModel getCpcById(Long id);

    List<CpcModel> getAllCpc();

    CpcModel updateCpcById(CpcModel cpcModel, Long id);

    void excelCpcUpload(MultipartFile file);
}
