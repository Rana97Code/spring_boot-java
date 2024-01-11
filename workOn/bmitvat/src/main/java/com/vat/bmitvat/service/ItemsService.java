package com.vat.bmitvat.service;

import com.vat.bmitvat.entity.ItemsEntity;
import com.vat.bmitvat.model.ItemsIndexModel;
import com.vat.bmitvat.model.ItemsModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ItemsService {
    ItemsModel saveSingleItem(ItemsModel itemsModel);

    ItemsModel getItemById(Long id);

    List<ItemsModel> getAllItems();

    List<ItemsIndexModel> getAllItemDetails();

    void excelItemUpload(MultipartFile file);

    List<ItemsIndexModel> getAllRawMaterials();

    List<ItemsIndexModel> getAllFinishGoods();


    List<ItemsModel> getAllItemsSuggestion();
}
