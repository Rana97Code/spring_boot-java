package com.vat.bmitvat.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryModel {
    private Long id;
    private String countryName;
    private String shortName;
    private Integer phoneCode;
}
