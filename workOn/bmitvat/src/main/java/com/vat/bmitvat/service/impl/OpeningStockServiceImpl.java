package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.entity.OpeningStockEntity;
import com.vat.bmitvat.entity.procurement.StockEntity;
import com.vat.bmitvat.entity.procurement.StockHistoryEntity;
import com.vat.bmitvat.mapper.OpeningStockMapper;
import com.vat.bmitvat.model.OpeningAddModel;
import com.vat.bmitvat.model.OpeningStockModel;
import com.vat.bmitvat.repository.OpeningStockRepository;
import com.vat.bmitvat.repository.StockHistoryRepository;
import com.vat.bmitvat.repository.StockRepository;
import com.vat.bmitvat.service.OpeningStockService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OpeningStockServiceImpl implements OpeningStockService {

    private final OpeningStockRepository openingStockRepository;
    private final StockHistoryRepository stockHistoryRepository;
    private final StockRepository stockRepository;


    public OpeningStockServiceImpl(OpeningStockRepository openingStockRepository, StockHistoryRepository stockHistoryRepository, StockRepository stockRepository) {
        this.openingStockRepository = openingStockRepository;
        this.stockHistoryRepository = stockHistoryRepository;
        this.stockRepository = stockRepository;
    }


    @Override
    public List<OpeningStockModel> getAllRawStock() {
        List<OpeningStockModel> openingStockModels = openingStockRepository.getAllRawMaterialsStock();
        return openingStockModels;
    }

    @Override
    public List<OpeningStockModel> getAllFinishStock() {
        List<OpeningStockModel> openingStockModels = openingStockRepository.getAllFinishGoodsStock();
        return openingStockModels;
    }

    @Override
    public OpeningAddModel saveOpeningStock(OpeningAddModel openingAddModel) {
        OpeningStockEntity openingStockEntity= OpeningStockMapper.MAPPER.modelToEntity(openingAddModel);
        OpeningStockEntity openingStockEntity1=openingStockRepository.save(openingStockEntity);
        Long insertId = openingStockEntity1.getId();
        Long openingItemId = openingAddModel.getItemId();
        this.openingStockRepository.updateStockStatus(openingItemId);

        BigDecimal bigDecimal = new BigDecimal("0");

        StockHistoryEntity stockHistoryEntity = new StockHistoryEntity();
        stockHistoryEntity.setItemId(openingItemId);
        stockHistoryEntity.setActionTbl("opening_stock");
        stockHistoryEntity.setActionTblId(insertId);
        stockHistoryEntity.setActionType("increment");
        stockHistoryEntity.setPreviousStock(bigDecimal);
        stockHistoryEntity.setQty(openingAddModel.getOpeningQuantity());
        stockHistoryEntity.setStatus(1);
        this.stockHistoryRepository.save(stockHistoryEntity);

        StockEntity stockEntity = new StockEntity();
        stockEntity.setItemId(openingItemId);
        stockEntity.setQty(openingAddModel.getOpeningQuantity());
        stockEntity.setStatus(1);
        this.stockRepository.save(stockEntity);

        return OpeningStockMapper.MAPPER.entityToModel(openingStockEntity1);
    }


}
