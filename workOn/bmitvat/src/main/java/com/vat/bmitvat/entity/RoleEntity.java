package com.vat.bmitvat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,updatable = false,nullable = false)
    private Long id;

    @Column(nullable = false, name = "role_name")
    private String roleName;

    @Column(nullable = false, name = "status")
    private Boolean status;

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
