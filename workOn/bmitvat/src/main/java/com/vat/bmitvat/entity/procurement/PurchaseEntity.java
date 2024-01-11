package com.vat.bmitvat.entity.procurement;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "purchase")
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,updatable = false,nullable = false)
    private Long id;

    @Column(nullable = true, name = "p_invoice_no")
    private String pInvoiceNo;

    @Column(nullable = true, name = "purchase_type")
    private Integer purchaseType;

    @Column(nullable = true, name = "purchase_category")
    private Integer purchaseCategory;

    @Column(nullable = true, name = "service_category")
    private Integer serviceCategory;

    @Column(nullable = true, name = "lc_date")
    private Date lcDate;

    @Column(nullable = true, name = "lc_no")
    private String lcNo;

    @Column(nullable = true, name = "chalan_date")
    private Date chalanDate;

    @Column(precision = 10, scale = 2, nullable = true, name = "total_vds")
    private BigDecimal totalVds;

    @Column(precision = 10, scale = 2, nullable = true, name = "grand_total")
    private BigDecimal grandTotal;

    @Column(nullable = true, name = "supplier_id")
    private Integer supplierId;

    @Column(precision = 10, scale = 2, nullable = true, name = "total_tax")
    private BigDecimal totalTax;

    @Column(nullable = true, name = "vendor_invoice")
    private String vendorInvoice;

    @Column(nullable = true, name = "entry_date")
    private Date entryDate;

    @Column(nullable = true, name = "notes")
    private String notes;

    @Column(nullable = true, name = "user_id")
    private Integer userId;

    @Column(nullable = true, name = "custom_house")
    private Integer customHouse;

    @Column(nullable = true, name = "country_origin")
    private Integer countryOrigin;

    @Column(nullable = true, name = "boe_item_no")
    private Integer boeItemNo;

    @Column(nullable = true, name = "data_source")
    private String dataSource;

    @Column(nullable = true, name = "cpc_code_id")
    private Integer cpcCodeId;

    @Column(nullable = false, name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;
}
