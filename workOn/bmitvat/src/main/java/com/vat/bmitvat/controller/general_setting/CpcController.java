package com.vat.bmitvat.controller.general_setting;

import com.vat.bmitvat.model.CpcModel;
import com.vat.bmitvat.model.CustomhouseModel;
import com.vat.bmitvat.service.CpcService;
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
public class CpcController {
    private final CpcService cpcService;
    @Autowired
    public CpcController(CpcService cpcService){
        this.cpcService=cpcService;
    }

    @PostMapping("/cpc/add-cpc")
    public ResponseEntity<CpcModel> saveSingleCpc(@RequestBody CpcModel cpcModel){
        CpcModel cpcModelRes=cpcService.saveSingleCpc(cpcModel);
        return ResponseEntity.ok().body(cpcModelRes);
    }
    @GetMapping("/cpc/all_cpc")
    public List<CpcModel> getAllCpc(){
        return cpcService.getAllCpc();
    }

    @GetMapping(path="/cpc/get_cpc/{id}")
    public ResponseEntity<CpcModel> getCpcById(@PathVariable Long id){
        CpcModel cpcModel=cpcService.getCpcById(id);
        return ResponseEntity.status(HttpStatus.OK).body(cpcModel);
    }

    @PutMapping("/cpc/update_customhouse/{id}")
    public ResponseEntity<CpcModel> updateCpcById(@RequestBody CpcModel cpcModel, @PathVariable Long id) {
        CpcModel cpcModel1 = cpcService.updateCpcById(cpcModel, id);
        return ResponseEntity.ok().body(cpcModel1);
    }

    @PostMapping("/cpc/upload_cpc_excel")
    public ResponseEntity<?> uploadCustomExcel(@RequestParam("file") MultipartFile file){

        cpcService.excelCpcUpload(file);
        return ResponseEntity.ok(Map.of("Message", "Custom House Excel Sheet Upload Successfully "));
    }

}

