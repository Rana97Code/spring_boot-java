package com.example.spring_mvn.service;

import com.example.spring_mvn.entity.Item;

import java.util.List;

public interface ItemService {
    void addItem(Item item);

    void addIarray(List<Item> item);

    List<Item> getAllItems();

    List<Item> findAllBySku(String sku);

    List<Item> findAllByItemType(String itemType);

    void updateArray(String itemType, List<Item> item);
}
