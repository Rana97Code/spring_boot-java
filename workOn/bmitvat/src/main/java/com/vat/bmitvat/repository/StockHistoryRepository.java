package com.vat.bmitvat.repository;

import com.vat.bmitvat.entity.procurement.StockHistoryEntity;
import com.vat.bmitvat.model.OpeningAddModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockHistoryRepository extends JpaRepository<StockHistoryEntity, Long> {

}
