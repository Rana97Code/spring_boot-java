package com.vat.bmitvat.repository;

import com.vat.bmitvat.entity.CustomhouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomhouseRepository extends JpaRepository<CustomhouseEntity,Long> {
}
