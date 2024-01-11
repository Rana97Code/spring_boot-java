package com.vat.bmitvat.repository.procurement;

import com.vat.bmitvat.entity.procurement.PurchaseEntity;
import com.vat.bmitvat.model.procurement.ItemDetailsModel;
import com.vat.bmitvat.model.procurement.LocalPurchaseModel;
import com.vat.bmitvat.model.response.PurchaseResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity,Long> {


    @Query("SELECT new com.vat.bmitvat.model.procurement.ItemDetailsModel(i.id, i.itemName, i.hsCodeId, i.hsCode, h.sd, h.vat)" +
            " FROM ItemsEntity i JOIN HsCodeEntity h ON i.hsCodeId = h.id WHERE i.id= :itemId")
    ItemDetailsModel getItemDetailsById(@Param("itemId") Long itemId);
    @Query("SELECT new com.vat.bmitvat.model.procurement.LocalPurchaseModel(p.id, p.pInvoiceNo, s.supplierName) FROM PurchaseEntity p LEFT JOIN PurchaseItemEntity pi ON p.id = pi.purchaseId LEFT JOIN SupplierEntity s ON p.supplierId = s.id GROUP BY p.id ")
    List<LocalPurchaseModel> getAllLocalPurchase();


    //    @Query(value="SELECT p.*, s.supplier_name FROM bmitvatdb.purchase p LEFT JOIN bmitvatdb.purchase_item pi ON p.id = pi.purchase_id LEFT JOIN bmitvatdb.supplier s ON p.supplier_id = s.id GROUP BY p.id", nativeQuery = true)


    //@Query("SELECT new com.example.spring_mvn.dto.UserAccessDTO(u.name, ua.accessId, ur.roleDetails) FROM User u JOIN u.useraccesses ua JOIN User_Role ur ON ur.id=ua.accessId")


//    @Query("SELECT new com.vat.bmitvat.model.response.PurchaseResponseDto(p.pInvoiceNo,pi.purchaseId,i.itemName) " +
//            "FROM PurchaseEntity p LEFT JOIN PurchaseItemEntity pi ON p.id = pi.purchase_id LEFT JOIN ItemsEntity i ON pi.item_id = i.id")

//    @Query(value = "SELECT u.id as userId, u.username, u.email, a.id as addressId, a.street, a.city " +
//            "FROM User u " +
//            "JOIN Address a ON u.id = a.user_id " +
//            "WHERE u.id = :userId", nativeQuery = true)
//    public List<PurchaseResponseDto> fetchFromPurchase();


//@Query(value="SELECT p.* FROM bmitvatdb.purchase p", nativeQuery = true)
//    @Query(value="SELECT * FROM bmitvatdb.purchase WHERE p_invoice_no=:val", nativeQuery = true)
//    public List<PurchaseEntity> fetchAllByInvoice(@Param("val") String inv);
//    @Query(value = "SELECT * FROM keyword_management.notice order by id desc limit 1", nativeQuery = true)
//    NoticeEntity latestNotice();

}
