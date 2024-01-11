package com.vat.bmitvat.service.procurement;

import com.vat.bmitvat.model.procurement.PurchaseItemModel;

import java.util.List;

public interface PurchaseItemService {
    PurchaseItemModel saveSinglePurchaseItem(PurchaseItemModel purchaseItemModel);

    List<PurchaseItemModel> saveLocalPurchaseItem(Long purchaseId, List<PurchaseItemModel> purchaseItems);
}
