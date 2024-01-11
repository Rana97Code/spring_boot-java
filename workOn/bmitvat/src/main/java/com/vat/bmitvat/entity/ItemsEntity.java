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
@Table(name="items")
public class ItemsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,updatable = false,nullable = false)
    private Long id;

    @Column(nullable = false, name = "item_name")
    private String itemName;

    @Column(nullable = false, name = "item_type")
    private Integer itemType;

    @Column(nullable = false, name = "hs_code")
    private String hsCode;

    @Column(nullable = true, name = "hs_code_id")
    private Integer hsCodeId;

    @Column(nullable = true, name = "hs_key_code")
    private String hsKeyCode;

    @Column(nullable = true, name = "calculate_year")
    private String calculateYear;

    @Column(nullable = true, name = "unit_id")
    private Integer unitId;

    @Column(nullable = true, name = "stock_status")
    private Integer stockStatus;

    @Column(nullable = true, name = "status")
    private Integer status;

    @Column(nullable = true, name = "created_by")
    private Integer createdBy;

    @Column(nullable = false, name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(nullable = true, name = "updated_by")
    private Integer updatedBy;

    @Column(nullable = false, name = "updated_at", updatable = false)
    @CreationTimestamp
    private Date updatedAt;
}