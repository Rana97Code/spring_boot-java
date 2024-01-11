package com.vat.bmitvat.controller.inventory;

import com.vat.bmitvat.entity.ItemsEntity;
import com.vat.bmitvat.model.ItemsIndexModel;
import com.vat.bmitvat.model.ItemsModel;
import com.vat.bmitvat.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class ItemsController {

    private final ItemsService itemsService;
    @Autowired
    public ItemsController(ItemsService itemsService){
        this.itemsService=itemsService;
    }


    @GetMapping("/item/all_items")
    public List<ItemsModel> getItems(){
        return itemsService.getAllItems();
    }


    @GetMapping("/item/all_raw_materials")
    public List<ItemsIndexModel> getRawMaterials(){
        return itemsService.getAllRawMaterials();
    }

    @GetMapping("/item/all_finish_goods")
    public List<ItemsIndexModel> getFinishGoods(){
        return itemsService.getAllFinishGoods();
    }

    @GetMapping("/item/all_details_items")
    public List<ItemsIndexModel> getItemD(){return  itemsService.getAllItemDetails(); }

    @PostMapping("/item/add-item")
    public ResponseEntity<ItemsModel> saveSingleItem(@RequestBody ItemsModel itemsModel){
        ItemsModel itemsModelRes=itemsService.saveSingleItem(itemsModel);
        return ResponseEntity.ok().body(itemsModelRes);
    }
    @GetMapping(path="/item/get_item/{id}")
    public ResponseEntity<ItemsModel> getUnitById(@PathVariable Long id){
        ItemsModel itemsModel=itemsService.getItemById(id);
        return ResponseEntity.status(HttpStatus.OK).body(itemsModel);
    }
//
//    @PutMapping("/item/update_item/{id}")
//    public ResponseEntity<ItemsModel> updateItemById(@RequestBody ItemsModel itemsModel, @PathVariable Long id) {
//        ItemsModel itemsModel1 = itemsService.updateItemById(itemsModel, id);
//        return ResponseEntity.ok().body(itemsModel1);
//    }

    @PostMapping("/item/upload_item_excel")
    public ResponseEntity<?> uploadItemExcel(@RequestParam("file") MultipartFile file){

        itemsService.excelItemUpload(file);
        return ResponseEntity.ok(Map.of("Message", "Item Excel Sheet Upload Successfully "));
    }


    @PostMapping("/item/getItemSuggestions")
    public List<ItemsModel> getSuggestions(@RequestBody String requestBody) {
        String searchTerm = requestBody.toLowerCase();
        List<ItemsModel> itemName = itemsService.getAllItemsSuggestion();

        return itemName.stream()
                .filter(suggestion -> suggestion.getItemName().toLowerCase().contains(searchTerm) )
                .collect(Collectors.toList());

    }
}

