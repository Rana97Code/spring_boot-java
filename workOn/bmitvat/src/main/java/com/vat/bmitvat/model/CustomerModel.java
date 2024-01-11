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
public class CustomerModel {
    private Long id;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;
    private Integer customerType;
    private Integer countryId;
    private Integer shippingCountryId;
    private String shippingAddress;
    private String customerTin;
    private String customerBinNid;
    private Integer createdBy;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
}