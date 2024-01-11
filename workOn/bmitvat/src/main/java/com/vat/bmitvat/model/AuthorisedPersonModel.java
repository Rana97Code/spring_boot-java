package com.vat.bmitvat.model;

import jakarta.persistence.Column;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorisedPersonModel {
    private Long id;
    private String personName;
    private String description;
    private String phoneNumber;
    private String nidNumber;
    private String emailAddress;
    private MultipartFile signature;
    private String createdBy;

    @Column(nullable = false, name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;

}
