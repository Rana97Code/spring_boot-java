package com.vat.bmitvat.model.response;

import com.vat.bmitvat.model.UnitsModel;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnitsResponseModel {
    private List<UnitsModel> data;
    private int total;
    private int page;
}
