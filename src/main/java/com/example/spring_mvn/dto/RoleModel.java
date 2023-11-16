package com.example.spring_mvn.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@ToString

//for ignore to print undefined item
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class RoleModel {

    private Integer roleId;
    private String roleName;
    private String roleDetails;
    public RoleModel(Integer roleId, String roleName, String roleDetails){
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDetails = roleDetails;
    }


}
