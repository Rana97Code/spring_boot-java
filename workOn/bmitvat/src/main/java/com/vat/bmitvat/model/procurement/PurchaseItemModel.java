package com.vat.bmitvat.model.procurement;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItemModel {
    private Long id;
    private Long purchaseId;
    private Long itemId;
    private BigDecimal quantity;
    private BigDecimal rate;
    private BigDecimal priceValue;
    private BigDecimal sd;
    private BigDecimal sdAmount;
    private BigDecimal vatableValue;
    private String vatType;
    private String vatRate;
    private BigDecimal vatAmount;
    private Integer vds;
    private Integer rebate;
    private BigDecimal totalAmount;
}
