package com.vat.bmitvat.service;

import com.vat.bmitvat.model.UnitsModel;
import com.vat.bmitvat.model.response.UnitsResponseModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UnitsService {
    UnitsModel saveSingleUnit(UnitsModel unitsModel);
    List<UnitsModel> getAllUnit();
    UnitsResponseModel getAllUnits(int page, int size);
    UnitsModel getUnitById(Long id);
    UnitsModel updateUnitById(UnitsModel unitsModel, Long id);
    String deleteUnitById(Long id);
    List<UnitsModel> findByAbbr(String abbr);
    List<UnitsModel> searchByUnitName(String unit);
    void excelUnitUpload(MultipartFile file);

//    List<UnitsModel> searchByUnitName1(String unit);
    //List<UnitsModel> searchAbbr(String keyword);
    //void excelUnitUpload(MultipartFile file);
}