package com.vat.bmitvat.service;

import com.vat.bmitvat.model.CustomerModel;

import java.util.List;

public interface CustomerService {
    CustomerModel saveSingleCustomer(CustomerModel customerModel);
    CustomerModel getCustomerById(Long id);
    CustomerModel updateCustomerById(CustomerModel customerModel, Long id);

    List<CustomerModel> getAllCustomer();
}
