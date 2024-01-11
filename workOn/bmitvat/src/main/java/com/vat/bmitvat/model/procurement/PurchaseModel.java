package com.vat.bmitvat.model.procurement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseModel {
    private Long id;
    private Integer supplierId;
    private Date entryDate;
    private String chalanNumber;
    private Date chalanDate;
    private String fiscalYear;
    private List<PurchaseItemModel> PurchaseItems;
    private BigDecimal totalTax;
    private BigDecimal totalSd;
    private BigDecimal grandTotal;
    private String note;

}
