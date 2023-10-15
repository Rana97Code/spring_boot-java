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
public class User_Access {

    @Id
    @GeneratedValue

    private Integer id;

    @Column(name="access_id")
    private Integer accessId;


    public void setId(Integer id) {
        this.id = id;
    }

//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }

    public void setAccessId(Integer accessId) {
        this.accessId = accessId;
    }
}
