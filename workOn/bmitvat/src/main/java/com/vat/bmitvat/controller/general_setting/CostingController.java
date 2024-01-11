package com.vat.bmitvat.controller.general_setting;

import com.vat.bmitvat.model.CostingModel;
import com.vat.bmitvat.model.UnitsModel;
import com.vat.bmitvat.service.CostingService;
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
public class CostingController {
    private final CostingService costingService;
    @Autowired
    public CostingController(CostingService costingService){
        this.costingService=costingService;
    }

    @PostMapping("/costing/add-costing")
    public ResponseEntity<CostingModel> saveSingleCosting(@RequestBody CostingModel costingModel){
        CostingModel costingModelRes=costingService.saveSingleCosting(costingModel);
        return ResponseEntity.ok().body(costingModelRes);
    }

    @GetMapping("/costing/all_costing")
    public List<CostingModel> getAllCosting(){
        return costingService.getAllCosting();
    }

    @GetMapping(path="/costing/get_costing/{id}")
    public ResponseEntity<CostingModel> getCostingById(@PathVariable Long id){
        CostingModel costingModel=costingService.getCostingById(id);
        return ResponseEntity.status(HttpStatus.OK).body(costingModel);
    }

    @PutMapping("/costing/update_costing/{id}")
    public ResponseEntity<CostingModel> updateCostignById(@RequestBody CostingModel costingModel, @PathVariable Long id) {
        CostingModel costingModel1 = costingService.updateCostingById(costingModel, id);
        return ResponseEntity.ok().body(costingModel1);
    }


    @PostMapping("/costing/upload_costing_excel")
    public ResponseEntity<?> uploadUnitExcel(@RequestParam("file") MultipartFile file){

        costingService.excelCostingUpload(file);
        return ResponseEntity.ok(Map.of("Message", "Unit Excel Sheet Upload Successfully "));
    }
}
