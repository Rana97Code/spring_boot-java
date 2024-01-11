package com.vat.bmitvat.model;

import java.math.BigDecimal;
import java.util.Date;
import lombok.*;


@Getter
@Setter
@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpeningAddModel {
    private Long itemId;
    private Integer itemType;
    private BigDecimal openingQuantity;
    private BigDecimal openingRate;
    private BigDecimal openingValue;
    private Date openingDate;
    private Date closingDate;
}
