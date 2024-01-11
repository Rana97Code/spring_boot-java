package com.vat.bmitvat.model.procurement;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalPurchaseModel {
    private Long id;
    private String pInvoiceNo;
    private String supplierName;

}
