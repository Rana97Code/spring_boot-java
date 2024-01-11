package com.vat.bmitvat.repository;

import com.vat.bmitvat.entity.OpeningStockEntity;
import com.vat.bmitvat.model.OpeningStockModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OpeningStockRepository extends JpaRepository<OpeningStockEntity, Long> {
    @Query("SELECT new com.vat.bmitvat.model.OpeningStockModel(i.id, i.itemName, i.hsCode, o.openingQuantity, o.openingRate, o.openingValue, o.openingDate)" +
            " FROM OpeningStockEntity o JOIN ItemsEntity i ON i.id=o.itemId WHERE o.itemType= 1 AND i.stockStatus= 1")
    List<OpeningStockModel> getAllRawMaterialsStock();

    @Query("SELECT new com.vat.bmitvat.model.OpeningStockModel(i.id, i.itemName, i.hsCode, o.openingQuantity, o.openingRate, o.openingValue, o.openingDate)" +
            " FROM OpeningStockEntity o JOIN ItemsEntity i ON i.id=o.itemId WHERE o.itemType= 2 AND i.stockStatus= 1")
    List<OpeningStockModel> getAllFinishGoodsStock();

    @Modifying
    @Transactional
    @Query("UPDATE ItemsEntity i SET i.stockStatus = 1 WHERE i.id = :openingItemId")
    void updateStockStatus(@Param("openingItemId") Long openingItemId);


//    @Query("SELECT new com.vat.bmitvat.model.TokenModel(u.id, u.username, u.userEmail, u.userPhone, u.userNid, u.nidScan, u.profileImage, u.userType)" +
//            " FROM UserEntity u WHERE u.username= :username")
//    TokenModel getItemDetails(@Param("username") String username);       WHERE i.itemType= 1 AND i.stockStatus= 0
}
