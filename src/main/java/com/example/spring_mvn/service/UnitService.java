package com.example.spring_mvn.service;

import com.example.spring_mvn.dto.UnitDTO;
import com.example.spring_mvn.entity.Unit;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UnitService {

    void excelUnitUpload(MultipartFile file);

//    Unit uploadExcelData(MultipartFile file, UnitDTO unitDTO);

}
