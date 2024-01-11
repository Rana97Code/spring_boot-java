package com.vat.bmitvat.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private Long id;
    private String username;
    private String userEmail;
//    private Integer status;
}
