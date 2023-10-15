package com.example.spring_mvn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue
    private Integer id;
    private String sku;

    @Column(name="item_name")
    private String itemName;

    @Column(name="item_type")
    private String itemType;

    @Column(name="hs_code")
    private String hsCode;

    @Column(name="unit_id")
    private Integer unitId;


    public void setId(Integer id) {
        this.id = id;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

//    public Item(Integer id, String sku, String itemName, String itemType, String hsCode, Integer unitId) {
//        this.id = id;
//        this.sku = sku;
//        this.itemName = itemName;
//        this.itemType = itemType;
//        this.hsCode = hsCode;
//        this.unitId = unitId;
//    }

//    public void setItem(List<Item> itemA) {
//    }
//
//    public void getItem(List<Item> item1) {
//    }
//
//    @Override
//    public String toString() {
//        return "Item{" +
//                "id=" + id +
//                ", sku='" + sku + '\'' +
//                ", itemName='" + itemName + '\'' +
//                ", itemType='" + itemType + '\'' +
//                ", hsCode='" + hsCode + '\'' +
//                ", unitId=" + unitId +
//                '}';
//    }

}
