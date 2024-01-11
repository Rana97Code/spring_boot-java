package com.vat.bmitvat.controller.procurement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vat.bmitvat.entity.procurement.PurchaseEntity;
import com.vat.bmitvat.model.SupplierModel;
import com.vat.bmitvat.model.procurement.ItemDetailsModel;
import com.vat.bmitvat.model.procurement.LocalPurchaseModel;
import com.vat.bmitvat.model.procurement.PurchaseItemModel;
import com.vat.bmitvat.model.procurement.PurchaseModel;
import com.vat.bmitvat.model.response.PurchaseResponseDto;
import com.vat.bmitvat.repository.procurement.PurchaseRepository;
import com.vat.bmitvat.service.procurement.PurchaseItemService;
import com.vat.bmitvat.service.procurement.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class PurchaseController {
    private final PurchaseService purchaseService;
    private final PurchaseItemService purchaseItemService;
    @Autowired
    private  PurchaseRepository purchaseRepository;
    @Autowired
    public PurchaseController(PurchaseService purchaseService, PurchaseItemService purchaseItemService){
        this.purchaseService=purchaseService;
        this.purchaseItemService = purchaseItemService;
    }


    @GetMapping("/purchase/get_item_details/{id}")
    public ResponseEntity<ItemDetailsModel> getItemDetailsById(@PathVariable Long id){
        ItemDetailsModel itemDetailsModel=purchaseService.getItemDetailsById(id);
        return ResponseEntity.status(HttpStatus.OK).body(itemDetailsModel);
    }


    @PostMapping("/purchase/add-local-purchase")
    public ResponseEntity<?> saveSinglePurchase(@RequestBody PurchaseModel purchaseModel) {
//        System.out.println(purchaseModel);
//        System.exit(1);
        Long purchaseId = purchaseService.saveLocalPurchase(purchaseModel);
        List<PurchaseItemModel> purchaseItemModel = purchaseItemService.saveLocalPurchaseItem(purchaseId, purchaseModel.getPurchaseItems());
        return ResponseEntity.ok().body(purchaseItemModel);
    }

    @GetMapping("/purchase/all-purchase")
    public List<LocalPurchaseModel> fetchPurchase(){
        return purchaseService.fetchAllLocalPurchase();
    }



}
