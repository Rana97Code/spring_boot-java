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
@Table(name="customhouse")
public class CustomhouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,updatable = false,nullable = false)
    private Long id;

    @Column(nullable = false, name = "house_name")
    private String houseName;

    @Column(nullable = false, name = "house_code")
    private String houseCode;

    @Column( name = "house_address")
    private String houseAddress;

    @Column(nullable = true, name = "created_by")
    private Integer createdBy;

    @Column(nullable = false, name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;
}
