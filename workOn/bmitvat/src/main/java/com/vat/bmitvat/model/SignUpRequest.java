package com.vat.bmitvat.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest implements Serializable {
    private String username;
    private String firstName;
    private String lastName;
    private String userEmail;
    private String userPhone;
    private String userNid;
    private MultipartFile nidScan;
    private MultipartFile profileImage;
    private String password;
    private Integer saleCenterId;
    private String userType;
    private Integer status;
    private Integer createdBy;
    private Integer updatedBy;

    public SignUpRequest(String username,String firstName, String lastName, String roleName, String userPhone, String userNid, MultipartFile nidScan, MultipartFile profileImage, String password, Integer saleCenterId,String userType, Integer status, Integer createdBy, Integer updatedBy ) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = roleName;
        this.userPhone = userPhone;
        this.userNid = userNid;
        this.nidScan = nidScan;
        this.profileImage = profileImage;
        this.password = password;
        this.saleCenterId = saleCenterId;
        this.userType = userType;
        this.status = status;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
}
