package com.vat.bmitvat.service;

import com.vat.bmitvat.model.CustomhouseModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CustomhouseService {
    CustomhouseModel saveSingleCustomHouse(CustomhouseModel customhouseModel);
    CustomhouseModel getCustomHouseById(Long id);

    List<CustomhouseModel> getAllCustom();

    CustomhouseModel updateCustomHouseById(CustomhouseModel customhouseModel, Long id);

    void excelCustomUpload(MultipartFile file);
}
