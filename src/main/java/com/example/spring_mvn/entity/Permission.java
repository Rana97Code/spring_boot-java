package com.example.spring_mvn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Permission {

    @Id
    @GeneratedValue

    private Long id;

    private String permissionName;

    private String permissionTag;
}
