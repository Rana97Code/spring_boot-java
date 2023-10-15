package com.example.spring_mvn.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
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
public class UserAccessDTO {


    private String name;
    private Integer accessId;
    private String roleDetails;
    //For define specific field
    public UserAccessDTO(String name, Integer accessId, String roleDetails){
        this.name = name;
        this.accessId = accessId;
        this.roleDetails = roleDetails;
    }


}
