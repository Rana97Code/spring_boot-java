package com.example.spring_mvn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;

    //for join table with foreign key
    @OneToMany(targetEntity = User_Access.class, cascade = CascadeType.ALL)
    @JoinColumn(name="u_id", referencedColumnName = "id")
    private List<User_Access> useraccesses;
}
