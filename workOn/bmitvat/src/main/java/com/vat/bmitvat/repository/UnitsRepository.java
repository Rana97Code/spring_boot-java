package com.vat.bmitvat.repository;

import com.vat.bmitvat.entity.UnitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitsRepository extends JpaRepository<UnitsEntity,Long> {


    List<UnitsEntity> findByAbbr(String abbr);
    List<UnitsEntity> findByUnitName(String unit);


}
