package com.vat.bmitvat.model.procurement;

import lombok.*;

import java.math.BigDecimal;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemDetailsModel {
    private Long id;
    private String itemName;
    private Integer hsCodeId;
    private String hsCode;
//    private BigDecimal quantity;
//    private BigDecimal rate;
//    private BigDecimal value;
    private BigDecimal sd;
//    private BigDecimal sdAmount;
//    private BigDecimal vatAbleValue;
//    private Integer vatType;
    private BigDecimal vat;
//    private BigDecimal vatAmount;
//    private Integer vds;
//    private Integer rebate;
//    private BigDecimal totalAmount;

    public ItemDetailsModel(Long id, String itemName, Integer hsCodeId, String hsCode, BigDecimal sd, BigDecimal vat){
        this.id = id;
        this.itemName = itemName;
        this.hsCodeId = hsCodeId;
        this.hsCode = hsCode;
        this.sd = sd;
        this.vat = vat;
    }


}
