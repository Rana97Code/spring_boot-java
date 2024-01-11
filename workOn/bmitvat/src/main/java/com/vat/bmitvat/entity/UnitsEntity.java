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
@Table(name="units")
public class UnitsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,updatable = false,nullable = false)
    private Long id;

    @Column(nullable = false, name = "unit_name")
    private String unitName;

    @Column(nullable = false, name = "abbr")
    private String abbr;

    @Column(nullable = false, name = "status")
    private Integer status;

    @Column(nullable = false, name = "created_by")
    private Integer createdBy;

    @Column(nullable = false, name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(nullable = false, name = "updated_by")
    private Integer updatedBy;

    @Column(nullable = false, name = "updated_at", updatable = false)
    @CreationTimestamp
    private Date updatedAt;
}
