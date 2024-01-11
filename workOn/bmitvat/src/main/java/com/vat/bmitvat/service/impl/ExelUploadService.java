package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.model.*;
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

public class ExelUploadService {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static boolean isValidExcelFile(MultipartFile file){

//        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" );

        return TYPE.equals(file.getContentType());
    }

    public static List<UnitsModel> getUnitsDataFromExcel(InputStream inputStream){
        List<UnitsModel> units = new ArrayList<>();
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
                UnitsModel unit = new UnitsModel();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
//                        case 0 -> unit.setId((int) cell.getNumericCellValue());
                        case 0 -> unit.setUnitName(cell.getStringCellValue());
                        case 1 -> unit.setAbbr(cell.getStringCellValue());
                        case 2 -> unit.setStatus((int) cell.getNumericCellValue());
                        case 3 -> unit.setCreatedBy((int) cell.getNumericCellValue());
                        case 4 -> unit.setUpdatedBy((int) cell.getNumericCellValue());
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

//    For Costing

    public static List<CostingModel> getCostingDataFromExcel(InputStream inputStream) {
        List<CostingModel> costingModels = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowIndex =1;
            for (Row row : sheet){
                if (rowIndex ==1){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                CostingModel costingModel = new CostingModel();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
//                        case 0 -> unit.setId((int) cell.getNumericCellValue());
                        case 0 -> costingModel.setCostingName(cell.getStringCellValue());
                        case 1 -> costingModel.setCostingType(cell.getStringCellValue());
                        case 2 -> costingModel.setCreatedBy((int) cell.getNumericCellValue());
                        default -> {
                        }
                    }
                    cellIndex++;
                }
                costingModels.add(costingModel);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return costingModels;
    }



    public static List<CustomhouseModel> getCustomDataFromExcel(InputStream inputStream) {
        List<CustomhouseModel> customhouseModels = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowIndex =1;
            for (Row row : sheet){
                if (rowIndex ==1){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                CustomhouseModel customhouseModel = new CustomhouseModel();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
//                        case 0 -> unit.setId((int) cell.getNumericCellValue());
                        case 0 -> customhouseModel.setHouseName(cell.getStringCellValue());
                        case 1 -> customhouseModel.setHouseCode(cell.getStringCellValue());
                        case 2 -> customhouseModel.setHouseAddress(cell.getStringCellValue());
                        case 3 -> customhouseModel.setCreatedBy((int) cell.getNumericCellValue());
                        default -> {
                        }
                    }
                    cellIndex++;
                }
                customhouseModels.add(customhouseModel);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return customhouseModels;
    }



    public static List<CpcModel> getCpcDataFromExcel(InputStream inputStream) {
        List<CpcModel> cpcModels = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowIndex =1;
            for (Row row : sheet){
                if (rowIndex ==1){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                CpcModel cpcModel = new CpcModel();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
//                        case 0 -> unit.setId((int) cell.getNumericCellValue());
                        case 0 -> cpcModel.setCpcDescription(cell.getStringCellValue());
                        case 1 -> cpcModel.setCreatedBy((int) cell.getNumericCellValue());
                        default -> {
                        }
                    }
                    cellIndex++;
                }
                cpcModels.add(cpcModel);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return cpcModels;
    }

    public static List<ItemsModel> getItemsDataFromExcel(InputStream inputStream) {
        List<ItemsModel> itemsModels = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowIndex =1;
            for (Row row : sheet){
                if (rowIndex ==1){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                ItemsModel itemsModel = new ItemsModel();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
//                        case 0 -> unit.setId((int) cell.getNumericCellValue());
                        case 0 -> itemsModel.setItemName(cell.getStringCellValue());
                        case 1 -> itemsModel.setItemType((int) cell.getNumericCellValue());
                        case 2 -> itemsModel.setHsCode(cell.getStringCellValue());
                        case 3 -> itemsModel.setUnitId((int) cell.getNumericCellValue());
                        case 4 -> itemsModel.setCalculateYear(cell.getStringCellValue());
                        case 5 -> itemsModel.setStockStatus((int) cell.getNumericCellValue());
                        case 6 -> itemsModel.setStatus((int) cell.getNumericCellValue());
                        case 7 -> itemsModel.setCreatedBy((int) cell.getNumericCellValue());

                        default -> {
                        }
                    }
                    cellIndex++;
                }
                itemsModels.add(itemsModel);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return itemsModels;
    }
}
