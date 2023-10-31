package com.example.spring_mvn.service.impl;

import com.example.spring_mvn.dto.UnitDTO;
//import com.example.spring_mvn.entity.Unit;
import com.example.spring_mvn.entity.Unit;
import com.example.spring_mvn.mapper.UnitMapper;
import com.example.spring_mvn.repository.UnitRepository;
import com.example.spring_mvn.service.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository unitRepository;



    @Override
    public void excelUnitUpload(MultipartFile file) {
        if(ExcelUploadService.isValidExcelFile(file)){
            try{
//                System.out.println(file.getSize());

                List<UnitDTO> unitDTO = ExcelUploadService.getUnitsDataFromExcel(file.getInputStream());
                System.out.println(unitDTO);

                //Convert Model to Entity
                List<Unit> unitsEntities = UnitMapper.MAPPER.dtoToEntity(unitDTO);
                unitRepository.saveAll(unitsEntities);

            } catch (IOException e){
                throw new IllegalArgumentException("This is not a valid Excel file !");
            }
        }
    }



}
