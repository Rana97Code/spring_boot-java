package com.example.spring_mvn.controller;

import com.example.spring_mvn.service.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @PostMapping("/upload_unit_excel")
    public ResponseEntity<?> uploadUnitExcel(@RequestParam("file")MultipartFile file){

        unitService.excelUnitUpload(file);
        return ResponseEntity.ok(Map.of("Message", "Unit Excel Sheet Upload Successfully "));
    }
}
