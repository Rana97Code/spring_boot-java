package com.example.spring_mvn.dto;

import com.example.spring_mvn.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccessDTO {
    private User user;
}
