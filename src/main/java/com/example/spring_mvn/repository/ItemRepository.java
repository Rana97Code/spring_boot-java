package com.example.spring_mvn.repository;

import com.example.spring_mvn.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Integer> {
    List<Item> findAllBySku(String sku);
    List<Item> findAllByItemType(String itemType);
}
