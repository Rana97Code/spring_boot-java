package com.example.spring_mvn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue
    private Integer id;
    private String sku;
    private String item_name;
    private String item_type;
    private String hs_code;
    private Integer unit_id;
}
