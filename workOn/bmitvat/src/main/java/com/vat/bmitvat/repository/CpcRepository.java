package com.vat.bmitvat.repository;

import com.vat.bmitvat.entity.CpcCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpcRepository extends JpaRepository<CpcCodeEntity,Long> {
}

