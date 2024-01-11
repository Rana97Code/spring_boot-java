package com.vat.bmitvat.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="authorised_person")
public class AuthorisedPersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,updatable = false,nullable = false)
    private Long id;

    @Column(nullable = false, name = "person_name")
    private String personName;
    @Column(nullable = false, name = "designation")
    private String description;
    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;
    @Column(nullable = false, name = "email_address")
    private String emailAddress;
    @Column(nullable = false, name = "nid_number")
    private String nidNumber;
    @Column(nullable = true, name = "signature")
    private String signature;
    @Column(nullable = true, name = "created_by")
    private Integer createdBy;

    @Column(nullable = false, name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;

}
