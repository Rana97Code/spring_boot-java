package com.vat.bmitvat.repository;

import com.vat.bmitvat.entity.CostingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostingRepository extends JpaRepository<CostingEntity,Long> {
}