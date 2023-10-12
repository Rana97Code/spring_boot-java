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
            itemRepository.saveAll(item);
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

    @Override
    public List<Item> findAllByItemType(String itemType) {
        return (List<Item>) itemRepository.findAllByItemType(itemType);
    }

    @Override
    public void updateArray(String itemType, List<Item> item) {
        List<Item> getItm = itemRepository.findAllByItemType(itemType);
//        System.out.println(getItm);
        for(int i=0; i<item.size(); i++){
//            System.out.println(item.get(i).getItemName());
//            System.out.println(getItm.get(i).getItemName());

            getItm.get(i).setSku(item.get(i).getSku());
            getItm.get(i).setItemName(item.get(i).getItemName());
            getItm.get(i).setItemType(item.get(i).getItemType());
            getItm.get(i).setHsCode(item.get(i).getHsCode());
            getItm.get(i).setUnitId(item.get(i).getUnitId());

            itemRepository.saveAll(getItm);
        }



    }



}
