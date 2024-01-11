package com.vat.bmitvat.service.procurement;
import com.vat.bmitvat.entity.procurement.PurchaseEntity;
import com.vat.bmitvat.model.procurement.ItemDetailsModel;
import com.vat.bmitvat.model.procurement.LocalPurchaseModel;
import com.vat.bmitvat.model.procurement.PurchaseModel;

import java.util.List;

public interface PurchaseService {
    

    ItemDetailsModel getItemDetailsById(Long id);

    Long saveLocalPurchase(PurchaseModel purchaseModel);

    List<LocalPurchaseModel> fetchAllLocalPurchase();


}
