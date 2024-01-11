package com.vat.bmitvat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="hs_code")
public class HsCodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,updatable = false,nullable = false)
    private Long id;

    @Column(nullable = true, name = "heading")
    private String heading;

    @Column(nullable = false, name = "hs_code")
    private String hsCode;

    @Column(nullable = true, name = "description")
    private String description;

    @Column(nullable = true, name = "description_bn")
    private String descriptionBn;

    @Column(precision = 10, scale = 2, name = "cd")
    private BigDecimal cd;

    @Column(precision = 10, scale = 2, name = "sd")
    private BigDecimal sd;

    @Column(precision = 10, scale = 2, name = "vat")
    private BigDecimal vat;

    @Column(precision = 10, scale = 2, name = "ait")
    private BigDecimal ait;

    @Column(precision = 10, scale = 2, name = "rd")
    private BigDecimal rd;

    @Column(precision = 10, scale = 2, name = "at")
    private BigDecimal at;

    @Column(precision = 10, scale = 2, name = "tti")
    private BigDecimal tti;

    @Column(nullable = true, name = "service_schedule")
    private String serviceSchedule;

    @Column(nullable = true, name = "schedule")
    private String schedule;

    @Column(nullable = true, name = "user_id")
    private Integer userId;

    @Column(nullable = true, name = "vat_type")
    private Integer vatType;

    @Column(nullable = true, name = "type")
    private Integer type;

    @Column(nullable = true, name = "year_start", updatable = false)
    private Date yearStart;

    @Column(nullable = true, name = "year_end", updatable = false)
    private Date yearEnd;

    @Column(nullable = true, name = "calculate_year")
    private String calculateYear;

    @Column(nullable = true, name = "keycode")
    private String keycode;

}
