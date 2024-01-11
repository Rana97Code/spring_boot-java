package com.vat.bmitvat.model.response;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseResponseDto {
    private Long id;
    private String pInvoiceNo;
    private Integer purchaseId;
    private String itemName;
}
