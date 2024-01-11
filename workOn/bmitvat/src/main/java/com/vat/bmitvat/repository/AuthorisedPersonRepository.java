package com.vat.bmitvat.repository;

import com.vat.bmitvat.entity.AuthorisedPersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorisedPersonRepository extends JpaRepository<AuthorisedPersonEntity, Long> {
}
