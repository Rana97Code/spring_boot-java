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
public class SupplierModel {
    private Long id;
    private String supplierName;
    private String supplierEmail;
    private String supplierPhone;
    private String supplierAddress;
    private Integer supplierType;
    private Integer countryId;
    private String supplierTin;
    private String supplierBinNid;
    private Integer createdBy;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
}
