package com.vat.bmitvat.service;


import com.vat.bmitvat.model.OpeningAddModel;
import com.vat.bmitvat.model.OpeningStockModel;

import java.util.List;

public interface OpeningStockService {
    List<OpeningStockModel> getAllRawStock();

    List<OpeningStockModel> getAllFinishStock();

    OpeningAddModel saveOpeningStock(OpeningAddModel openingAddModel);

}
