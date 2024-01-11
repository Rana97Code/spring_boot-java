package com.vat.bmitvat.service.impl.procurement;

import com.vat.bmitvat.entity.ItemsEntity;
import com.vat.bmitvat.entity.procurement.PurchaseEntity;
import com.vat.bmitvat.entity.procurement.PurchaseItemEntity;
import com.vat.bmitvat.entity.procurement.StockEntity;
import com.vat.bmitvat.entity.procurement.StockHistoryEntity;
import com.vat.bmitvat.mapper.ItemsMapper;
import com.vat.bmitvat.mapper.UnitsMapper;
import com.vat.bmitvat.mapper.procurement.PurchaseItemMapper;
import com.vat.bmitvat.model.ItemsModel;
import com.vat.bmitvat.model.procurement.PurchaseItemModel;
import com.vat.bmitvat.repository.StockHistoryRepository;
import com.vat.bmitvat.repository.StockRepository;
import com.vat.bmitvat.repository.procurement.PurchaseItemRepository;
import com.vat.bmitvat.service.procurement.PurchaseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseItemServiceImpl implements PurchaseItemService {
    private final PurchaseItemRepository purchaseItemRepository;
    private final StockRepository stockRepository;
    private final StockHistoryRepository stockHistoryRepository;
    @Autowired
    public PurchaseItemServiceImpl(PurchaseItemRepository purchaseItemRepository, StockRepository stockRepository, StockHistoryRepository stockHistoryRepository){
        this.purchaseItemRepository=purchaseItemRepository;
        this.stockRepository = stockRepository;
        this.stockHistoryRepository = stockHistoryRepository;
    }

//    @Override
//    public ItemsModel getItemDetailsById(Long id) {
//        Optional<ItemsEntity> itemsEntity = purchaseItemRepository.getItemDetailsById(id);
//        ItemsModel itemsModel = ItemsMapper.MAPPER.entityToModel(itemsEntity.get());
//        return itemsModel;
//    }

    @Override
    public PurchaseItemModel saveSinglePurchaseItem(PurchaseItemModel purchaseItemModel) {
        PurchaseItemEntity purchaseItemEntityReq= PurchaseItemMapper.MAPPER.modelToEntity(purchaseItemModel);
        PurchaseItemEntity purchaseItemEntityRes=purchaseItemRepository.save(purchaseItemEntityReq);
        return PurchaseItemMapper.MAPPER.entityToModel(purchaseItemEntityRes);
    }

    @Override
    public List<PurchaseItemModel> saveLocalPurchaseItem(Long purchaseId, List<PurchaseItemModel> purchaseItemsModel) {
        List<PurchaseItemEntity> purchaseItemEntities = new ArrayList<>();
        for (PurchaseItemModel purchaseItemModel : purchaseItemsModel) {
            PurchaseItemEntity purchaseItemEntity = PurchaseItemEntity.builder()
                    .purchaseId(purchaseId)
                    .itemId(purchaseItemModel.getItemId())
                    .qty(purchaseItemModel.getQuantity())
                    .rate(purchaseItemModel.getRate())
                    .amount(purchaseItemModel.getPriceValue())
                    .itemSd(purchaseItemModel.getSd())
                    .sdAmount(purchaseItemModel.getSdAmount())
                    .vatableValue(purchaseItemModel.getVatableValue())
                    .vatType(purchaseItemModel.getVatType())
                    .taxAmount(purchaseItemModel.getVatAmount())
                    .vds(purchaseItemModel.getVds())
                    .rate(purchaseItemModel.getRate())
                    .tAmount(purchaseItemModel.getTotalAmount())
                    .build();
            purchaseItemEntities.add(purchaseItemEntity);

                //For current stock check and get
                StockEntity stockEntity = stockRepository.getThisItemStock(purchaseItemModel.getItemId());
                var preStock = stockEntity.getQty();

                //Update current stock
                stockEntity.setQty(stockEntity.getQty().add(purchaseItemModel.getQuantity()));
                stockRepository.save(stockEntity);

                //Stock histoy update
                StockHistoryEntity stockHistoryEntity = new StockHistoryEntity();
                stockHistoryEntity.setItemId(purchaseItemModel.getItemId());
                stockHistoryEntity.setActionTbl("purchase");
                stockHistoryEntity.setActionTblId(purchaseId);
                stockHistoryEntity.setActionType("increment");
                stockHistoryEntity.setPreviousStock(preStock);
                stockHistoryEntity.setQty(purchaseItemModel.getQuantity());
                stockHistoryEntity.setStatus(1);
                this.stockHistoryRepository.save(stockHistoryEntity);
        }
//        System.out.println(purchaseItemEntities);
        List<PurchaseItemEntity> savedEntities = purchaseItemRepository.saveAll(purchaseItemEntities);

        return null;
    }


}
