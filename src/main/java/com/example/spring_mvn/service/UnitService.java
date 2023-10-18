package com.example.spring_mvn.service;

import com.example.spring_mvn.entity.Unit;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UnitService {

    void excelUnitUpload(MultipartFile file);

//    List<Unit> excelUnitUpload();
}
