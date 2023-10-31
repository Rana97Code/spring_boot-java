package com.example.spring_mvn.dto;

import com.example.spring_mvn.entity.Unit;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Getter
@Setter
@Builder

public class UnitDTO {
    private Long id;
    private String unitName;
    private String abbreviation;

}
