package com.vat.bmitvat.controller.procurement;

import com.vat.bmitvat.model.procurement.PurchaseItemModel;
import com.vat.bmitvat.service.procurement.PurchaseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class PurchaseItemController {
    private final PurchaseItemService purchaseItemService;
    @Autowired
    public PurchaseItemController(PurchaseItemService purchaseItemService){
        this.purchaseItemService=purchaseItemService;
    }



    @PostMapping("/purchase/add-purchase-item")
    public ResponseEntity<PurchaseItemModel> saveSinglePurchaseItem(@RequestBody PurchaseItemModel purchaseItemModel){
        PurchaseItemModel purchaseItemModelRes=purchaseItemService.saveSinglePurchaseItem(purchaseItemModel);
        return ResponseEntity.ok().body(purchaseItemModelRes);
    }

}
