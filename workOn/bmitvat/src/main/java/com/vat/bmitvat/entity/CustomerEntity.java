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
@Table(name="customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,updatable = false,nullable = false)
    private Long id;

    @Column(name = "customer_name",nullable = false)
    private String customerName;

    @Column(name = "customer_email",nullable = true)
    private String customerEmail;

    @Column(name = "customer_phone",nullable = true)
    private String customerPhone;

    @Column(name = "customer_address",nullable = true)
    private String customerAddress;

    @Column(name = "customer_type",nullable = true)
    private Integer customerType;

    @Column(name = "country_id",nullable = true)
    private Integer countryId;

    @Column(name = "customer_tin",nullable = true)
    private String customerTin;

    @Column(name = "shipping_country_id",nullable = true)
    private Integer shippingCountryId;

    @Column(name = "shipping_address",nullable = true)
    private String shippingAddress;

    @Column(name = "customer_bin_nid",nullable = true)
    private String customerBinNid;

    @Column(nullable = true, name = "created_by")
    private Integer createdBy;

    @Column(nullable = false, name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;
}
