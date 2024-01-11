package com.vat.bmitvat.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TokenModel {
    private Long id;
    private String username;
    private String userEmail;
    private String userPhone;
    private String userNid;
    private String nidScan;
    private String profileImage;
    private String userType;


    public TokenModel(Long id, String username, String userEmail, String userPhone, String userNid, String nidScan, String profileImage, String userType){
        this.id = id;
        this.username = username;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userNid = userNid;
        this.nidScan = nidScan;
        this.profileImage= profileImage;
        this.userType = userType;
    }

}
