package com.vat.bmitvat.repository;

import com.vat.bmitvat.entity.ItemsEntity;
import com.vat.bmitvat.model.ItemsIndexModel;
import com.vat.bmitvat.model.ItemsModel;
import com.vat.bmitvat.model.TokenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsEntity,Long> {


    @Query("SELECT new com.vat.bmitvat.model.ItemsIndexModel(i.id, i.itemName, h.description, i.itemType, i.hsCode, i.calculateYear, u.unitName, i.status)" +
            " FROM ItemsEntity i JOIN UnitsEntity u ON u.id=i.unitId JOIN HsCodeEntity h ON h.id=i.hsCodeId")
    List<ItemsIndexModel> getAllItemDetails();

    //update items hs_code_id after excel upload
    @Modifying
    @Transactional
    @Query("UPDATE ItemsEntity i SET i.hsCodeId = (SELECT CONCAT(h.id) FROM HsCodeEntity h WHERE i.hsCode = h.hsCode)")
    void hsCodeUpdate();

    @Query("SELECT new com.vat.bmitvat.model.ItemsIndexModel(i.id, i.itemName, h.description, i.itemType, i.hsCode, i.calculateYear, u.unitName, i.status)" +
            " FROM ItemsEntity i JOIN UnitsEntity u ON u.id=i.unitId JOIN HsCodeEntity h ON h.id=i.hsCodeId WHERE i.itemType= 1 AND i.stockStatus= 0")
    List<ItemsIndexModel> getAllRawMaterials();

    @Query("SELECT new com.vat.bmitvat.model.ItemsIndexModel(i.id, i.itemName, h.description, i.itemType, i.hsCode, i.calculateYear, u.unitName, i.status)" +
            " FROM ItemsEntity i JOIN UnitsEntity u ON u.id=i.unitId JOIN HsCodeEntity h ON h.id=i.hsCodeId WHERE i.itemType= 2 AND i.stockStatus= 0")
    List<ItemsIndexModel> getAllFinishGoods();

    @Query("SELECT new com.vat.bmitvat.model.ItemsModel(i.id, i.itemName,i.itemType,i.hsCode, i.hsCodeId, i.hsKeyCode, i.calculateYear,i.unitId, i.stockStatus,i.status,i.createdBy,i.createdAt,i.updatedBy,i.updatedAt )" +
            " FROM ItemsEntity i WHERE i.stockStatus= 1")
    List<ItemsModel> getAllItemSuggestion();


//    @Query("SELECT new com.vat.bmitvat.model.TokenModel(u.id, u.username, u.userEmail, u.userPhone, u.userNid, u.nidScan, u.profileImage, u.userType)" +
//            " FROM UserEntity u WHERE u.username= :username")
//    TokenModel getItemDetails(@Param("username") String username);       WHERE i.itemType= 1 AND i.stockStatus= 0
}
