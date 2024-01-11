package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.entity.ItemsEntity;
import com.vat.bmitvat.entity.UnitsEntity;
import com.vat.bmitvat.mapper.ItemsMapper;
import com.vat.bmitvat.mapper.UnitsMapper;
import com.vat.bmitvat.model.ItemsIndexModel;
import com.vat.bmitvat.model.ItemsModel;
import com.vat.bmitvat.model.UnitsModel;
import com.vat.bmitvat.repository.ItemsRepository;
import com.vat.bmitvat.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemsServiceImpl implements ItemsService {
    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemsServiceImpl(ItemsRepository itemsRepository){
        this.itemsRepository=itemsRepository;
    }
    @Override
    public ItemsModel saveSingleItem(ItemsModel itemsModel){
        ItemsEntity itemsEntityReq= ItemsMapper.MAPPER.modelToEntity(itemsModel);
        ItemsEntity itemsEntityRes=itemsRepository.save(itemsEntityReq);
        return ItemsMapper.MAPPER.entityToModel(itemsEntityRes);

    }

    @Override
    public ItemsModel getItemById(Long id) {
        Optional<ItemsEntity> itemsEntity = itemsRepository.findById(id);
        ItemsModel itemsModel = ItemsMapper.MAPPER.entityToModel(itemsEntity.get());
        return itemsModel;
    }

    @Override
    public List<ItemsModel> getAllItems() {
        List<ItemsEntity> itemsEntities = itemsRepository.findAll();
        List<ItemsModel> itemsModels = ItemsMapper.MAPPER.entityToModel(itemsEntities);
        return itemsModels;

    }

    @Override
    public List<ItemsIndexModel> getAllItemDetails() {
        List<ItemsIndexModel> itemsIndexModels = itemsRepository.getAllItemDetails();
        return itemsIndexModels;
    }

    @Override
    public void excelItemUpload(MultipartFile file) {
        if (ExelUploadService.isValidExcelFile(file)) {
            try {
                List<ItemsModel> itemsModels = ExelUploadService.getItemsDataFromExcel(file.getInputStream());
                List<ItemsEntity> itemsEntities = ItemsMapper.MAPPER.modelToEntity(itemsModels);
                this.itemsRepository.saveAll(itemsEntities);
                this.itemsRepository.hsCodeUpdate();
            } catch (IOException e) {
                throw new IllegalArgumentException("This is not a valid Excel file !");
            }
        }
    }

    @Override
    public List<ItemsIndexModel> getAllRawMaterials() {
        List<ItemsIndexModel> itemsModels = itemsRepository.getAllRawMaterials();
        return itemsModels;
    }

    @Override
    public List<ItemsIndexModel> getAllFinishGoods() {
        List<ItemsIndexModel> itemsModels = itemsRepository.getAllFinishGoods();
        return itemsModels;
    }

    @Override
    public List<ItemsModel> getAllItemsSuggestion() {
        List<ItemsModel> itemsModel = itemsRepository.getAllItemSuggestion();
        return itemsModel;
    }


}

