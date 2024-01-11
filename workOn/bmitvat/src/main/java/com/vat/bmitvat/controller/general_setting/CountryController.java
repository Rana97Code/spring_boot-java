package com.vat.bmitvat.controller.general_setting;
import com.vat.bmitvat.model.CountryModel;
import com.vat.bmitvat.model.CpcModel;
import com.vat.bmitvat.model.SupplierModel;
import com.vat.bmitvat.model.UnitsModel;
import com.vat.bmitvat.service.CountryService;
import com.vat.bmitvat.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/country/all_country")
    public List<CountryModel> getAllCountry(){
        return countryService.getAllCountry();
    }
}
