package com.example.spring_mvn.repository;

import com.example.spring_mvn.dto.UnitDTO;

import com.example.spring_mvn.entity.Unit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

//    public List<UnitDTO> saveExcel();
//    void saveAll(List<? extends Unit> unit);

//    void saveAllUnit(List<UnitDTO> unit);
}
