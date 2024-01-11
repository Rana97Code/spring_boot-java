package com.vat.bmitvat.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomhouseModel {
    private Long id;
    private String houseName;
    private String houseCode;
    private String houseAddress;
    private Integer createdBy;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
}
