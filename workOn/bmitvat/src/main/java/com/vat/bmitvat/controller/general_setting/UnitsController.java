package com.vat.bmitvat.controller.general_setting;

import com.vat.bmitvat.model.UnitsModel;
import com.vat.bmitvat.model.response.UnitsResponseModel;
import com.vat.bmitvat.service.UnitsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class UnitsController {
    private final UnitsService unitsService;
    @Autowired
    public UnitsController(UnitsService unitsService){
        this.unitsService=unitsService;
    }

    @PostMapping("/unit/add-unit")
    public ResponseEntity<UnitsModel> saveSingleUnit(@RequestBody UnitsModel unitsModel){
        UnitsModel unitsModelRes=unitsService.saveSingleUnit(unitsModel);
        return ResponseEntity.ok().body(unitsModelRes);
    }

    @GetMapping(path="/get_unit/{id}")
    public ResponseEntity<UnitsModel> getUnitById(@PathVariable Long id){
        UnitsModel unitsModel=unitsService.getUnitById(id);
        return ResponseEntity.status(HttpStatus.OK).body(unitsModel);
    }

//        @CrossOrigin(origins = "http://localhost:5173/")

    //SecurityRequirement for Swagger Authorization SecurityRequirement
//    @SecurityRequirement(name = "authToken")
    @GetMapping("/unit/allunits")
    public List<UnitsModel> getAllUnit(){
        return unitsService.getAllUnit();
    }

    @GetMapping("/unit/all")
    public ResponseEntity <UnitsResponseModel> getAllUnits(
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "page", defaultValue = "0") int page,
            Principal principal
    ){
        UnitsResponseModel unitsList = unitsService.getAllUnits(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(unitsList);
    }
//    @GetMapping("/allunits")
//    public ResponseEntity <List<UnitsResponseModel>> getAllUnit(){
//        UnitsResponseModel unitsLists = unitsService.getAllUnit();
//        return ResponseEntity.status(HttpStatus.OK).body(unitsLists);
//    }

    @PutMapping("/update_unit/{id}")
    public ResponseEntity<UnitsModel> updateUnitById(@RequestBody UnitsModel unitsModel, @PathVariable Long id) {
        UnitsModel unitsModelRes = unitsService.updateUnitById(unitsModel, id);
        return ResponseEntity.ok().body(unitsModelRes);
    }

    @DeleteMapping("/unit/{id}")
    public ResponseEntity<String> deleteUnitById(@PathVariable Long id) {
        String res = unitsService.deleteUnitById(id);
        return ResponseEntity.ok().body(res);
    }



    @GetMapping("/unit/abbr/{abbr}")
    public List<UnitsModel> searchByAbbr(@PathVariable String abbr) {
        return unitsService.findByAbbr(abbr);
    }
    @GetMapping("/unit/name/{unit}")
    public List<UnitsModel> searchByUnitName(@PathVariable String unit) {
        return unitsService.searchByUnitName(unit);
    }



    @PostMapping("/unit/upload_unit_excel")
    public ResponseEntity<?> uploadUnitExcel(@RequestParam("file") MultipartFile file){

        unitsService.excelUnitUpload(file);
        return ResponseEntity.ok(Map.of("Message", "Unit Excel Sheet Upload Successfully "));
    }

}
