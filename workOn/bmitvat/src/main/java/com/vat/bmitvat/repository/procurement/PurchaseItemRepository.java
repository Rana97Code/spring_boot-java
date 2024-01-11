package com.vat.bmitvat.repository.procurement;

import com.vat.bmitvat.entity.procurement.PurchaseItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseItemRepository extends JpaRepository<PurchaseItemEntity,Long> {
}
