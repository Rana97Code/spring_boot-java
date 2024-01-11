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
@Table(name = "role_permissions")
public class RolePermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,updatable = false,nullable = false)
    private Long id;

    @Column(nullable = false, name = "role_id")
    private Integer roleId;

    @Column(nullable = false, name = "permission_id")
    private Integer permissionId;

    @Column(nullable = false, name = "list_view")
    private Boolean listView;

    @Column(nullable = false, name = "create_permission")
    private Boolean createPermission;

    @Column(nullable = false, name = "update_permission")
    private Boolean updatePermission;


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
