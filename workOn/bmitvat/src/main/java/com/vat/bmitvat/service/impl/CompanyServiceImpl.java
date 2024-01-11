package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.entity.CompanyEntity;
import com.vat.bmitvat.mapper.CompanyMapper;
import com.vat.bmitvat.model.CompanyModel;
import com.vat.bmitvat.repository.CompanyRepository;
import com.vat.bmitvat.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository){ this.companyRepository=companyRepository;
    }

    @Override
    public String updateCompany(CompanyModel companyModel, Long id){

        return String.valueOf(companyRepository.findById(id)
                .map(topic -> {
                    topic.setCompanyName(companyModel.getCompanyName());
                    topic.setComSortName(companyModel.getComSortName());
                    topic.setComEmail(companyModel.getComEmail());
                    topic.setComPhone(companyModel.getComPhone());
                    topic.setLoginLogo(companyModel.getLoginLogo().getOriginalFilename());
                    topic.setStreet(companyModel.getStreet());
                    topic.setCountryId(companyModel.getCountryId());
                    topic.setComTin(companyModel.getComTin());
                    topic.setComBin(companyModel.getComBin());
                    topic.setComBank(companyModel.getComBank());
                    topic.setComBankBranch(companyModel.getComBankBranch());
                    topic.setComBankAcc(companyModel.getComBankAcc());
                    topic.setInvoiceLogo(companyModel.getInvoiceLogo().getOriginalFilename());
                    topic.setComCurrency(companyModel.getComCurrency());
                    topic.setBusinessNature(companyModel.getBusinessNature());
                    topic.setBusinessEconomics(companyModel.getBusinessEconomics());
                    topic.setAuthorisedPersonId(companyModel.getAuthorisedPersonId());
                    topic.setVatType(companyModel.getVatType());
                    topic.setStatus(companyModel.getStatus());

                    return companyRepository.save(topic);
                }));
    }

    @Override
    public Optional<CompanyEntity> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

}