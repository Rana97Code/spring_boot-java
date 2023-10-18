package com.example.spring_mvn.repository;

import com.example.spring_mvn.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
}
