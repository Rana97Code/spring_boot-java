package com.vat.bmitvat.service.impl.procurement;

import com.vat.bmitvat.entity.procurement.PurchaseEntity;
import com.vat.bmitvat.mapper.procurement.PurchaseMapper;
import com.vat.bmitvat.model.procurement.ItemDetailsModel;
import com.vat.bmitvat.model.procurement.LocalPurchaseModel;
import com.vat.bmitvat.model.procurement.PurchaseModel;
import com.vat.bmitvat.repository.procurement.PurchaseRepository;
import com.vat.bmitvat.service.procurement.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;
    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository){ this.purchaseRepository=purchaseRepository;
    }

    @Override
    public ItemDetailsModel getItemDetailsById(Long id) {
        return purchaseRepository.getItemDetailsById(id);
    }


    @Override
    public Long saveLocalPurchase(PurchaseModel purchaseModel) {
//            System.out.println(purchaseModel);
        String randomKey = UUID.randomUUID().toString();
        var purchase = PurchaseEntity.builder()
                .pInvoiceNo(randomKey)
                .purchaseType(1)
                .purchaseCategory(1)
                .lcNo(purchaseModel.getChalanNumber())
                .lcDate(purchaseModel.getChalanDate())
                .chalanDate(purchaseModel.getChalanDate())
                .supplierId(purchaseModel.getSupplierId())
                .grandTotal(purchaseModel.getGrandTotal())
                .totalTax(purchaseModel.getTotalTax())
                .notes(purchaseModel.getNote())
                .userId(1)
                .build();
        PurchaseEntity purchaseEntity = purchaseRepository.save(purchase);
        return purchaseEntity.getId();
    }


    @Override
    public List<LocalPurchaseModel> fetchAllLocalPurchase() {
        return purchaseRepository.getAllLocalPurchase();
    }

}
