package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.model.CountryModel;
import com.vat.bmitvat.model.UnitsModel;
import com.vat.bmitvat.repository.CountryRepository;
import com.vat.bmitvat.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<CountryModel> getAllCountry() {
        return countryRepository.findAll().stream().map(country -> {
            CountryModel countryModel = new CountryModel();
            countryModel.setId(country.getId());
            countryModel.setCountryName(country.getCountryName());
            countryModel.setShortName(country.getShortName());
            countryModel.setPhoneCode(country.getPhoneCode());
            return countryModel;
        }).collect(Collectors.toList());
    }
}
