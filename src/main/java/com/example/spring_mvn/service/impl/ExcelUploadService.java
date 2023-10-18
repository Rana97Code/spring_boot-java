package com.example.spring_mvn.service.impl;

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

    public static List<Unit> getUnitsDataFromExcel(InputStream inputStream){
        List<Unit> units = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
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
                Unit unit = new Unit();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
                        case 0 -> unit.setId((int) cell.getNumericCellValue());
                        case 1 -> unit.setUnitName(cell.getStringCellValue());
                        case 2 -> unit.setAbbreviation(cell.getStringCellValue());
                        default -> {
                        }
                    }
                    cellIndex++;
                }
                units.add(unit);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return units;
    }
}
