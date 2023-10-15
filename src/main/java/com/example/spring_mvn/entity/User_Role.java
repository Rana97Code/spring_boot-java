package com.example.spring_mvn.entity;

import jakarta.persistence.Column;
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
public class User_Role {

    @Id
    @GeneratedValue

    private Integer id;

    @Column(name="role_tag")
    private String roleTag;

    @Column(name="role_details")
    private String roleDetails;


}
