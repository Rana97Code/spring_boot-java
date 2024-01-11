package com.vat.bmitvat.service;

import com.vat.bmitvat.model.SupplierModel;

import java.util.List;

public interface SupplierService {
    SupplierModel saveSingleSupplier(SupplierModel supplierModel);
    SupplierModel getSupplierById(Long id);
    SupplierModel updateSupplierById(SupplierModel supplierModel, Long id);

    List<SupplierModel> getAllSupplier();
}
