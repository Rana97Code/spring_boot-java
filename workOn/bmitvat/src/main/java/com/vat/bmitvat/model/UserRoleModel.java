package com.vat.bmitvat.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleModel {
    private Long id;
    private Long userId;
    private Long roleId;
}