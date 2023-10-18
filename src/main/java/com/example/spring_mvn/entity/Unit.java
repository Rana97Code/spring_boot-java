package com.example.spring_mvn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Unit {
    @Id
//    @GeneratedValue

    private Integer id;

    @Column(name="unit_name")
    private String unitName;

    private String abbreviation;
}
