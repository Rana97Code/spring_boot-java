package com.example.spring_mvn.service.impl;

import com.example.spring_mvn.dto.UnitDTO;
import com.example.spring_mvn.entity.Unit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ExcelUploadService {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static boolean isValidExcelFile(MultipartFile file){

//        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" );

        return TYPE.equals(file.getContentType());
    }

    public static List<UnitDTO> getUnitsDataFromExcel(InputStream inputStream){
        List<UnitDTO> units = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
//            Sheet1 is the number of Sheet
            XSSFSheet sheet = workbook.getSheet("Sheet1");
//            System.out.println(sheet);
//            System.out.println(workbook.getSheetName(0));
            int rowIndex =1;
            for (Row row : sheet){
                if (rowIndex ==1){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                UnitDTO unitDTO = new UnitDTO();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
                        //   case 0 -> unit.setId((int) cell.getNumericCellValue());
                        case 0 -> unitDTO.setUnitName(cell.getStringCellValue());
                        case 1 -> unitDTO.setAbbreviation(cell.getStringCellValue());

                        default -> {
                        }
                    }
                    cellIndex++;
                }
                units.add(unitDTO);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return units;
    }
}
