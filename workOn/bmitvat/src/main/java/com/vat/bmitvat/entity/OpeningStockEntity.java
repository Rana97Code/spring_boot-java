package com.vat.bmitvat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="opening_stock")
public class OpeningStockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,updatable = false,nullable = false)
    private Long id;

    @Column(nullable = false, name = "item_id")
    private Long itemId;

    @Column(nullable = false, name = "item_type")
    private Integer itemType;

    @Column(nullable = true, name = "invoice_id")
    private String invoiceId;

    @Column(precision = 10, scale = 2,nullable = true, name = "opening_quantity")
    private BigDecimal openingQuantity;

    @Column(precision = 10, scale = 2,nullable = true, name = "opening_rate")
    private BigDecimal openingRate;

    @Column(precision = 10, scale = 2,nullable = true, name = "opening_value")
    private BigDecimal openingValue;

    @Column(nullable = true, name = "created_by")
    private Integer createdBy;

    @Column(nullable = true, name = "closing_date")
    private Date closingDate;

    @Column(nullable = true, name = "opening_date")
    private Date openingDate;

    @Column(nullable = true, name = "updated_by")
    private Integer updatedBy;

    @Column(nullable = false, name = "updated_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;
}
