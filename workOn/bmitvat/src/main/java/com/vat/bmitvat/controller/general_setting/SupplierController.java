package com.vat.bmitvat.controller.general_setting;

import com.vat.bmitvat.model.CpcModel;
import com.vat.bmitvat.model.SupplierModel;
import com.vat.bmitvat.model.UnitsModel;
import com.vat.bmitvat.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class SupplierController {
    private final SupplierService supplierService;
    @Autowired
    public SupplierController(SupplierService supplierService){
        this.supplierService=supplierService;
    }

    @PostMapping("/supplier/add-supplier")
    public ResponseEntity<SupplierModel> saveSingleSupplier(@RequestBody SupplierModel supplierModel){
        SupplierModel supplierModelRes=supplierService.saveSingleSupplier(supplierModel);
        return ResponseEntity.ok().body(supplierModelRes);
    }

    @GetMapping("/supplier/all_supplier")
    public List<SupplierModel> getAllSupplier(){
        return supplierService.getAllSupplier();
    }

    @GetMapping(path="/supplier/get_supplier/{id}")
    public ResponseEntity<SupplierModel> getSupplierById(@PathVariable Long id){
        SupplierModel supplierModel=supplierService.getSupplierById(id);
        return ResponseEntity.status(HttpStatus.OK).body(supplierModel);
    }

    @PutMapping("/supplier/update_supplier/{id}")
    public ResponseEntity<SupplierModel> updateSupplierById(@RequestBody SupplierModel supplierModel, @PathVariable Long id) {
        SupplierModel supplierModel1 = supplierService.updateSupplierById(supplierModel, id);
        return ResponseEntity.ok().body(supplierModel1);
    }
}
