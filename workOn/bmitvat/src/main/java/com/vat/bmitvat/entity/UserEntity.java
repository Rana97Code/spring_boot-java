package com.vat.bmitvat.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_email")
    private String userEmail;

    @Column(nullable = true, name = "user_phone")
    private String userPhone;

    @Column(name = "user_password")
    private String password;

    @Column(nullable = true, name = "first_name")
    private String firstName;

    @Column(nullable = true, name = "last_name")
    private String lastName;

    @Column(nullable = true, name = "user_nid")
    private String userNid;

    @Column(nullable = true, name = "nid_scan")
    private String nidScan;

    @Column(nullable = true, name = "profile_image")
    private String profileImage;

    @Column(nullable = true, name = "sale_center_id")
    private Integer saleCenterId;

    @Column(nullable = true, name = "user_type")
    private String userType;

    @Column(nullable = true, name = "terminate_date")
    private Date terminateDate;

    @Column(nullable = true, name = "terminate_reason")
    private String terminateReason;

    @Column(nullable = true, name = "status")
    private Integer status;

    @Column(nullable = true, name = "created_by")
    private Integer createdBy;

    @Column(nullable = true, name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(nullable = true, name = "updated_by")
    private Integer updatedBy;

    @Column(nullable = true, name = "updated_at", updatable = false)
    @CreationTimestamp
    private Date updatedAt;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

//    @Column(nullable = true, name = "sale_center_id")
//    private Integer saleCenterId;
//
//    @Column(nullable = true, name = "user_type")
//    private String userType;
//
//    @Column(nullable = true, name = "first_name")
//    private String firstName;
//
//    @Column(nullable = true, name = "last_name")
//    private String lastName;
//
//    @Column(nullable = true, name = "user_nid")
//    private String userNid;
//
//    @Column(nullable = true, name = "nid_scan")
//    private String nidScan;
//
//    @Column(nullable = true, name = "user_phone")
//    private String userPhone;
//
//    @Column(nullable = true, name = "terminate_date")
//    private Date terminateDate;
//
//    @Column(nullable = true, name = "terminate_reason")
//    private String terminateReason;
//    @Column(nullable = true, name = "status")
//    private Boolean status;
//
//
//    @Column(nullable = true, name = "created_by")
//    private Integer createdBy;
//
//    @Column(nullable = true, name = "created_at", updatable = false)
//    @CreationTimestamp
//    private Date createdAt;
//
//    @Column(nullable = true, name = "updated_by")
//    private Integer updatedBy;
//
//    @Column(nullable = true, name = "updated_at", updatable = false)
//    @CreationTimestamp
//    private Date updatedAt;





}
