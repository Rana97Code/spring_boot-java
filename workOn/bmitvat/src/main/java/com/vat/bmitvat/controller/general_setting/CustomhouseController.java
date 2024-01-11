package com.vat.bmitvat.controller.general_setting;

import com.vat.bmitvat.model.CostingModel;
import com.vat.bmitvat.model.CustomhouseModel;
import com.vat.bmitvat.service.CustomhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class CustomhouseController {
    private final CustomhouseService customhouseService;
    @Autowired
    public CustomhouseController(CustomhouseService customhouseService){
        this.customhouseService=customhouseService;
    }

    @PostMapping("/customhouse/add-customhouse")
    public ResponseEntity<CustomhouseModel> saveSingleCustomHouse(@RequestBody CustomhouseModel customhouseModel){
        CustomhouseModel customhouseModelRes=customhouseService.saveSingleCustomHouse(customhouseModel);
        return ResponseEntity.ok().body(customhouseModelRes);
    }

    @GetMapping("/customhouse/all_customhouse")
    public List<CustomhouseModel> getAllCustom(){
        return customhouseService.getAllCustom();
    }

    @GetMapping(path="/customhouse/get_customhouse/{id}")
    public ResponseEntity<CustomhouseModel> getCustomById(@PathVariable Long id){
        CustomhouseModel customhouseModel=customhouseService.getCustomHouseById(id);
        return ResponseEntity.status(HttpStatus.OK).body(customhouseModel);
    }

    @PutMapping("/customhouse/update_customhouse/{id}")
    public ResponseEntity<CustomhouseModel> updateCustomHouseById(@RequestBody CustomhouseModel customhouseModel, @PathVariable Long id) {
        CustomhouseModel customhouseModel1 = customhouseService.updateCustomHouseById(customhouseModel, id);
        return ResponseEntity.ok().body(customhouseModel1);
    }


    @PostMapping("/customhouse/upload_customhouse_excel")
    public ResponseEntity<?> uploadCustomExcel(@RequestParam("file") MultipartFile file){

        customhouseService.excelCustomUpload(file);
        return ResponseEntity.ok(Map.of("Message", "Custom House Excel Sheet Upload Successfully "));
    }
}

