package com.vat.bmitvat.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
//@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HsCodeModel {
    private Long id;
    private String heading;
    private String hsCode;
    private String description;
    private String descriptionBn;
    private BigDecimal cd;
    private BigDecimal sd;
    private BigDecimal vat;
    private BigDecimal ait;
    private BigDecimal rd;
    private BigDecimal at;
    private BigDecimal tti;
    private String serviceSchedule;
    private String schedule;
    private Integer userId;
    private Integer vatType;
    private Integer type;
    private Date yearStart;
    private Date yearEnd;
    private String calculateYear;
    private String keycode;

}
