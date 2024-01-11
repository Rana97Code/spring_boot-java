package com.vat.bmitvat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="supplier")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,updatable = false,nullable = false)
    private Long id;

    @Column(name = "supplier_name",nullable = false)
    private String supplierName;

    @Column(name = "supplier_email",nullable = true)
    private String supplierEmail;

    @Column(name = "supplier_phone",nullable = true)
    private String supplierPhone;

    @Column(name = "supplier_address",nullable = true)
    private String supplierAddress;

    @Column(name = "supplier_type",nullable = true)
    private Integer supplierType;

    @Column(name = "country_id",nullable = true)
    private Integer countryId;

    @Column(name = "supplier_tin",nullable = true)
    private String supplierTin;

    @Column(name = "supplier_bin_nid",nullable = true)
    private String supplierBinNid;

    @Column(nullable = true, name = "created_by")
    private Integer createdBy;

    @Column(nullable = false, name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;

}
