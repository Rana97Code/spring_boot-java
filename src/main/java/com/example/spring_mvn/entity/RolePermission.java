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
public class RolePermission {
    @Id
    @GeneratedValue

    private Long id;

    @Column(name="role_id")
    private String roleId;

    @Column(name="permission_id")
    private String permissionId;
}
