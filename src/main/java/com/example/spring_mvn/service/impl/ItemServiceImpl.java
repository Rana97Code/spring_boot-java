package com.example.spring_mvn.service.impl;

import com.example.spring_mvn.entity.Item;
import com.example.spring_mvn.repository.ItemRepository;
import com.example.spring_mvn.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void addItem(Item item) {

        itemRepository.save(item);
    }

    @Override
    public void addIarray(List<Item> item) {
//        for (int i = 0; i < item.size(); i++) {
            itemRepository.saveAll(item);
//        System.out.println(item.get(i));
//        }
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> findAllBySku(String sku) {
        return (List<Item>) itemRepository.findAllBySku(sku);
//        return null;
    }


}
