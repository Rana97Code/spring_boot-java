package com.vat.bmitvat.controller.general_setting;

import com.vat.bmitvat.model.HsCodeModel;
import com.vat.bmitvat.service.HsCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class HsCodeController {
    private final HsCodeService hsCodeService;

    @Autowired
    public HsCodeController(HsCodeService hsCodeService) {
        this.hsCodeService = hsCodeService;
    }

    @GetMapping("/hs_code/all_hs-code")
    public List<HsCodeModel> getAllUnit(){
        return hsCodeService.getAllHsCode();
    }
}
