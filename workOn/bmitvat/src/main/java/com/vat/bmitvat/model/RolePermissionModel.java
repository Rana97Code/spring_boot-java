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
public class RolePermissionModel {

    private Long id;
    private Integer roleId;
    private Integer permissionId;
    private Boolean listView;
    private Boolean createPermission;
    private Boolean updatePermission;

    private Boolean status;
    private Integer createdBy;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    private Integer updatedBy;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
}
