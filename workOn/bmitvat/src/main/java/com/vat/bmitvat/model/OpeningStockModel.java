package com.vat.bmitvat.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpeningStockModel {
    private Long id;
    private String itemName;
    private String hsCode;
    private BigDecimal openingQuantity;
    private BigDecimal openingRate;
    private BigDecimal openingValue;
    private Date openingDate;

}
