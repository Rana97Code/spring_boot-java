package com.vat.bmitvat.controller.inventory;

import com.vat.bmitvat.model.ItemsIndexModel;
import com.vat.bmitvat.model.ItemsModel;
import com.vat.bmitvat.model.OpeningAddModel;
import com.vat.bmitvat.model.OpeningStockModel;
import com.vat.bmitvat.service.OpeningStockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class OpeningController {

    private final OpeningStockService openingStockService;

    public OpeningController(OpeningStockService openingStockService) {
        this.openingStockService = openingStockService;
    }

    @GetMapping("/opening_stock/all_raw_stock")
    public List<OpeningStockModel> getRawMaterials(){
        return openingStockService.getAllRawStock();
    }

    @GetMapping("/opening_stock/all_finish_stock")
    public List<OpeningStockModel> getFinishGoods(){
        return openingStockService.getAllFinishStock();
    }

    @PostMapping("/opening_stock/add-opening-stock")
    public ResponseEntity<OpeningAddModel> saveRawStock(@RequestBody OpeningAddModel openingAddModel){
        OpeningAddModel openingAddModel1=openingStockService.saveOpeningStock(openingAddModel);
        return ResponseEntity.ok().body(openingAddModel1);
    }

}
