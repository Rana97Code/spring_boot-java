package com.vat.bmitvat.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UserAccessModel {
    private Long id;
    private String role_id;
    private String user_id;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
}
