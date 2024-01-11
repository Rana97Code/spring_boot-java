package com.vat.bmitvat.service;

import com.vat.bmitvat.entity.CompanyEntity;
import com.vat.bmitvat.model.CompanyModel;

import java.util.Optional;

public interface CompanyService {
    String updateCompany(CompanyModel companyModel, Long id);

    Optional<CompanyEntity> getCompanyById(Long id);
}
