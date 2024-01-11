package com.vat.bmitvat.controller.procurement;

import com.vat.bmitvat.entity.test.PersonAddressDto;
import com.vat.bmitvat.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class TestController {
    @Autowired
    private TestRepository testRepository;

    @GetMapping("/list")
    public ResponseEntity<List<PersonAddressDto>> getUserListWithAddress() {
        List<PersonAddressDto> userAddressDTOList = testRepository.getUserAddressDTOList();

        // Check if the list is not empty
        if (!userAddressDTOList.isEmpty()) {
            return ResponseEntity.ok(userAddressDTOList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
