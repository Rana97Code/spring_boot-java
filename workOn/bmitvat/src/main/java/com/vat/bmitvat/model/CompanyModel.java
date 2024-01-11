package com.vat.bmitvat.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyModel {
    private Long id;
    private String companyName;
    private String comSortName;
    private String comEmail;
    private String comPhone;
    private MultipartFile loginLogo;
    private String street;
    private Integer countryId;
    private String comTin;
    private String comBin;
    private String comBank;
    private String comBankBranch;
    private String comBankAcc;
    private MultipartFile invoiceLogo;
    private String comCurrency;
    private String businessNature;
    private String businessEconomics;
    private Integer authorisedPersonId;
    private String vatType;
    private Boolean status;
    private Integer createdBy;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    private Integer updatedBy;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
}