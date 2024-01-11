package com.vat.bmitvat.repository;

import com.vat.bmitvat.entity.procurement.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {

    @Query("SELECT new com.vat.bmitvat.entity.procurement.StockEntity(se.id, se.itemId, se.qty, se.status, se.createdAt) FROM StockEntity se WHERE se.itemId= :itemId")
    StockEntity getThisItemStock(@Param("itemId") Long itemId);
}
