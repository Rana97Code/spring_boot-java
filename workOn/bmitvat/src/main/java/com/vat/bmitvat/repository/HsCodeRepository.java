package com.vat.bmitvat.repository;

import com.vat.bmitvat.entity.HsCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HsCodeRepository extends JpaRepository<HsCodeEntity, Long> {
}
