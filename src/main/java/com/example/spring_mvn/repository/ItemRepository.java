package com.example.spring_mvn.repository;

import com.example.spring_mvn.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
    List<Item> findAllBySku(String sku);
    List<Item> findAllByItemType(String itemType);
}
