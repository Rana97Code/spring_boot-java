package com.example.spring_mvn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue

    private Integer id;

    @Column(name="role_id")
    private Long roleId;

    @Column(name="user_id")
    private Long userId;


}
