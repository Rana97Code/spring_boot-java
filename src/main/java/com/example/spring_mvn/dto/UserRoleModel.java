package com.example.spring_mvn.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRoleModel {
    private Long id;
    private Long roleId;
    private String username;
    private String roleName;


    public UserRoleModel(Long id,Long roleId, String username, String roleName){
        this.id = id;
        this.roleId = roleId;
        this.username = username;
        this.roleName = roleName;
    }

}