package com.vat.bmitvat.controller.general_setting;

import com.vat.bmitvat.entity.CompanyEntity;
import com.vat.bmitvat.model.CompanyModel;
import com.vat.bmitvat.model.CostingModel;
import com.vat.bmitvat.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class CompanyController {
    private final CompanyService companyService;

    private static final String UPLOAD_DIR = "D:\\Java\\BMIT\\bmitvatjava\\frontend\\public\\assets\\images\\company";
    @Autowired
    public CompanyController(CompanyService companyService){
        this.companyService=companyService;
    }

    @GetMapping(path="/company/get-company/{id}")
    public ResponseEntity<Optional<CompanyEntity>> getCompanyById(@PathVariable Long id){
        Optional<CompanyEntity> companyEntity=companyService.getCompanyById(id);
        return ResponseEntity.status(HttpStatus.OK).body(companyEntity);
    }


    @PutMapping("/company/update-company/{id}")
    public String updateCompany(@ModelAttribute CompanyModel companyModel, @PathVariable Long id){

        var file1 = companyModel.getLoginLogo();
        var file2 = companyModel.getInvoiceLogo();

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        String LoginLogo = file1.getOriginalFilename();
        File ndestFile = new File(uploadDir.getAbsolutePath() + File.separator + LoginLogo);

        String invoiceLogo = file2.getOriginalFilename();
        File pdestFile = new File(uploadDir.getAbsolutePath() + File.separator + invoiceLogo);

        try {
            file1.transferTo(ndestFile);
            file2.transferTo(pdestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return companyService.updateCompany(companyModel, id);

    }

}
