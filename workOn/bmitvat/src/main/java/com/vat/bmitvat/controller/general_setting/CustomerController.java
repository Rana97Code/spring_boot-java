package com.vat.bmitvat.controller.general_setting;

import com.vat.bmitvat.model.CpcModel;
import com.vat.bmitvat.model.CustomerModel;
import com.vat.bmitvat.model.UnitsModel;
import com.vat.bmitvat.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @PostMapping("/customer/add-customer")
    public ResponseEntity<CustomerModel> saveSingleCustomer(@RequestBody CustomerModel customerModel){
        CustomerModel customerModelRes=customerService.saveSingleCustomer(customerModel);
        return ResponseEntity.ok().body(customerModelRes);
    }

    @GetMapping("/customer/all_customer")
    public List<CustomerModel> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping(path="/customer/get_customer/{id}")
    public ResponseEntity<CustomerModel> getCustomerById(@PathVariable Long id){
        CustomerModel customerModel=customerService.getCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(customerModel);
    }
    @PutMapping("/customer/update_customer/{id}")
    public ResponseEntity<CustomerModel> updateCustomerById(@RequestBody CustomerModel customerModel, @PathVariable Long id) {
        CustomerModel customerModel1 = customerService.updateCustomerById(customerModel, id);
        return ResponseEntity.ok().body(customerModel1);
    }
}