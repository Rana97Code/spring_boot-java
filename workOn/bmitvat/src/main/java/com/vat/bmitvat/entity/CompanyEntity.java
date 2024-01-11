package com.vat.bmitvat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "company_details")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,updatable = false,nullable = false)
    private Long id;

    @Column(nullable = true, name = "company_name")
    private String companyName;

    @Column(nullable = true, name = "co_short_name")
    private String comSortName;

    @Column(nullable = true, name = "com_email")
    private String comEmail;

    @Column(nullable = true, name = "com_phone")
    private String comPhone;

    @Column(nullable = true, name = "login_logo")
    private String loginLogo;

    @Column(nullable = true, name = "street")
    private String street;

    @Column(nullable = true, name = "country_id")
    private Integer countryId;

    @Column(nullable = true, name = "com_tin")
    private String comTin;

    @Column(nullable = true, name = "com_bin")
    private String comBin;

    @Column(nullable = true, name = "com_bank")
    private String comBank;

    @Column(nullable = true, name = "com_bank_branch")
    private String comBankBranch;

    @Column(nullable = true, name = "com_bank_acc")
    private String comBankAcc;

    @Column(nullable = true, name = "invoice_logo")
    private String invoiceLogo;

    @Column(nullable = true, name = "com_currency")
    private String comCurrency;

    @Column(nullable = true, name = "business_nature")
    private String businessNature;

    @Column(nullable = true, name = "business_economics")
    private String businessEconomics;

    @Column(nullable = true, name = "authorised_person_id")
    private Integer authorisedPersonId;

    @Column(nullable = true, name = "vat_type")
    private String vatType;

    @Column(nullable = true, name = "status")
    private Boolean status;

    @Column(nullable = true, name = "created_by")
    private Integer createdBy;

    @Column(nullable = true, name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(nullable = true, name = "updated_by")
    private Integer updatedBy;

    @Column(nullable = true, name = "updated_at", updatable = true)
    @CreationTimestamp
    private Date updatedAt;
}
