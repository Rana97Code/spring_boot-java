package com.example.spring_mvn.controller;

import com.example.spring_mvn.entity.Item;
import com.example.spring_mvn.service.ItemService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("item")
@SecurityRequirement(name = "authToken")
public class ItemController {

    @Autowired
    private ItemService itemService;


    @PostMapping("/add_item")
    public String addItem(@RequestBody Item item){
        itemService.addItem(item);
        return "Item Insert Successfully";
    }


    @PostMapping("/add_item_array")
    public String addArray(@RequestBody List<Item> item){
        itemService.addIarray(item);
        return "Successfully Insert Array";
    }

    @GetMapping("/get_all_item")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping("/get_all_item/{sku}")
    public List<Item> findAllBySku(@PathVariable String sku){
        return itemService.findAllBySku(sku);

    }

    @GetMapping("/getall_by_type/{itemType}")
    public List<Item> findAllByItemType(@PathVariable String itemType){
        return itemService.findAllByItemType(itemType);
    }

    @PutMapping("/update_array/{itemType}")
    public ResponseEntity<Void> updateArray(@PathVariable String itemType , @RequestBody List<Item> item){
        itemService.updateArray(itemType, item);
       return ResponseEntity.noContent().build();
    }



}
