package com.vat.bmitvat.model;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@Builder
@ToString
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class ItemsIndexModel {
    private Long id;
    private String itemName;
    private String description;
    private Integer itemType;
    private String hsCode;
    private String calculateYear;
    private String unitName;
    private Integer status;

    public ItemsIndexModel(Long id, String itemName, String description, Integer itemType, String hsCode, String calculateYear, String unitName, Integer status ) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.itemType = itemType;
        this.hsCode = hsCode;
        this.calculateYear = calculateYear;
        this.unitName = unitName;
        this.status = status;

    }
}
