package com.vat.bmitvat.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemsModel {
    private Long id;
    private String itemName;
    private Integer itemType;
    private String hsCode;
    private Integer hsCodeId;
    private String hsKeyCode;
    private String calculateYear;
    private Integer unitId;
    private Integer stockStatus;
    private Integer status;
    private Integer createdBy;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    private Integer updatedBy;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
}