package com.example.spring_mvn.service.impl;

import com.example.spring_mvn.entity.Unit;
import com.example.spring_mvn.repository.UnitRepository;
import com.example.spring_mvn.service.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository unitRepository;

    @Override
    public void excelUnitUpload(MultipartFile file) {
        if(ExcelUploadService.isValidExcelFile(file)){
            try{
                System.out.println(file.getSize());

                List<Unit> units = ExcelUploadService.getUnitsDataFromExcel(file.getInputStream());

                System.out.println(units);
                this.unitRepository.saveAll(units);
            } catch (IOException e){
                throw new IllegalArgumentException("This is not a valid Excel file !");
            }
        }
    }


}
