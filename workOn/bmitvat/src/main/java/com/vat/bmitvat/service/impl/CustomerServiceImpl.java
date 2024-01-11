package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.entity.CustomerEntity;
import com.vat.bmitvat.entity.ItemsEntity;
import com.vat.bmitvat.mapper.CustomerMapper;
import com.vat.bmitvat.mapper.ItemsMapper;
import com.vat.bmitvat.model.CustomerModel;
import com.vat.bmitvat.model.ItemsModel;
import com.vat.bmitvat.repository.CustomerRepository;
import com.vat.bmitvat.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){ this.customerRepository=customerRepository;
    }
    @Override
    public CustomerModel saveSingleCustomer(CustomerModel customerModel){
        CustomerEntity customerEntityReq= CustomerMapper.MAPPER.modelToEntity(customerModel);
        CustomerEntity customerEntityRes=customerRepository.save(customerEntityReq);
        return CustomerMapper.MAPPER.entityToModel(customerEntityRes);

    }


    @Override
    public CustomerModel getCustomerById(Long id){
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        CustomerModel customerModel = CustomerMapper.MAPPER.entityToModel(customerEntity.get());
        return customerModel;
    }


    @Override
    public CustomerModel updateCustomerById(CustomerModel customerModel, Long id) {
        CustomerEntity customerEntity = CustomerMapper.MAPPER.modelToEntity(customerModel);
        return customerRepository.findById(id)
                .map(topic -> {
                    topic.setCustomerName(customerEntity.getCustomerName());
                    return CustomerMapper.MAPPER.entityToModel(customerRepository.save(topic));
                })
                .orElseGet(() -> {
                    return CustomerMapper.MAPPER.entityToModel(customerRepository.save(customerEntity));
                });
    }

    @Override
    public List<CustomerModel> getAllCustomer() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        List<CustomerModel> customerModels = CustomerMapper.MAPPER.entityToModel(customerEntities);
        return customerModels;
    }


}

