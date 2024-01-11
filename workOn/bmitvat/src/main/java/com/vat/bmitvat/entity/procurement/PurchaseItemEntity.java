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
@Table(name = "purchase_item")
public class PurchaseItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,updatable = false,nullable = false)
    private Long id;

    @Column(nullable = false, name = "item_id")
    private Long itemId;

    @Column(nullable = false, name = "purchase_id")
    private Long purchaseId;

    @Column(nullable = true, name = "boe_item_no")
    private Integer boeItemNo;

    @Column(nullable = true, name = "hs_code")
    private String hsCode;

    @Column(nullable = true, name = "hs_code_id")
    private Long hsCodeId;

    @Column(nullable = true, name = "service_code")
    private String serviceCode;

    @Column(precision = 10, scale = 2, nullable = true, name = "qty")
    private BigDecimal qty;

    @Column(precision = 10, scale = 2, nullable = true, name = "rate")
    private BigDecimal rate;

    @Column(precision = 10, scale = 2, nullable = true, name = "item_tax")
    private BigDecimal itemTax;

    @Column(precision = 10, scale = 2, nullable = true, name = "tax_amount")
    private BigDecimal taxAmount;

    @Column(precision = 10, scale = 2, nullable = true, name = "item_cd")
    private BigDecimal itemCd;

    @Column(precision = 10, scale = 2, nullable = true, name = "cd_amount")
    private BigDecimal cdAmount;

    @Column(precision = 10, scale = 2, nullable = true, name = "item_sd")
    private BigDecimal itemSd;

    @Column(precision = 10, scale = 2, nullable = true, name = "sd_amount")
    private BigDecimal sdAmount;

    @Column(precision = 10, scale = 2, nullable = true, name = "item_rd")
    private BigDecimal itemRd;

    @Column(precision = 10, scale = 2, nullable = true, name = "rd_amount")
    private BigDecimal rdAmount;

    @Column(precision = 10, scale = 2, nullable = true, name = "item_at")
    private BigDecimal itemAt;

    @Column(precision = 10, scale = 2, nullable = true, name = "at_amount")
    private BigDecimal atAmount;

    @Column(precision = 10, scale = 2, nullable = true, name = "item_ait")
    private BigDecimal itemAit;

    @Column(precision = 10, scale = 2, nullable = true, name = "ait_amount")
    private BigDecimal aitAmount;

    @Column(precision = 10, scale = 2, nullable = true, name = "item_tti")
    private BigDecimal itemTti;

    @Column(precision = 10, scale = 2, nullable = true, name = "tti_amount")
    private BigDecimal ttiAmount;

    @Column(precision = 10, scale = 2, nullable = true, name = "amount")
    private BigDecimal amount;

    @Column(precision = 10, scale = 2, nullable = true, name = "t_amount")
    private BigDecimal tAmount;

    @Column(precision = 10, scale = 2, nullable = true, name = "access_amount")
    private BigDecimal accessAmount;

    @Column(precision = 10, scale = 2, nullable = true, name = "vatable_value")
    private BigDecimal vatableValue;

    @Column(nullable = true, name = "vat_type")
    private String vatType;

    @Column(nullable = true, name = "vds")
    private Integer vds;

    @Column(nullable = true, name = "rebate")
    private Integer rebate;

    @Column(nullable = true, name = "purchase_date")
    private Date purchaseDate;

    @Column(nullable = true, name = "entry_date")
    private Date entryDate;

    @Column(nullable = true, name = "p_date")
    @CreationTimestamp
    private Date pDate;
}
