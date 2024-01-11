package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.entity.AuthorisedPersonEntity;
import com.vat.bmitvat.entity.UserEntity;
import com.vat.bmitvat.mapper.AuthorisedPersonMapper;
import com.vat.bmitvat.model.AuthorisedPersonModel;
import com.vat.bmitvat.repository.AuthorisedPersonRepository;
import com.vat.bmitvat.service.AuthorisedPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorisedPersonServiceImpl implements AuthorisedPersonService {

    private final AuthorisedPersonRepository authorisedPersonRepository;

    @Autowired
    public AuthorisedPersonServiceImpl(AuthorisedPersonRepository authorisedPersonRepository) {
        this.authorisedPersonRepository = authorisedPersonRepository;
    }

    @Override
    public String saveSinglePerson(AuthorisedPersonModel authorisedPersonModel) {
        var person = AuthorisedPersonEntity.builder()
                .personName(authorisedPersonModel.getPersonName())
                .description(authorisedPersonModel.getDescription())
                .phoneNumber(authorisedPersonModel.getPhoneNumber())
                .emailAddress(authorisedPersonModel.getEmailAddress())
                .nidNumber(authorisedPersonModel.getNidNumber())
                .signature(authorisedPersonModel.getSignature().getOriginalFilename())
                .build();
         authorisedPersonRepository.save(person);
        return "Successfully Insert";
    }


    @Override
    public List<AuthorisedPersonEntity> getAllPerson() {
        return authorisedPersonRepository.findAll();
    }

//    @Override
//    public List<AuthorisedPersonModel> getAllPerson() {
//        List<AuthorisedPersonEntity> authorisedPersonEntities = authorisedPersonRepository.findAll();
//        return authorisedPersonEntities.stream()
//                .map(AuthorisedPersonMapper.MAPPER.entityToModel())
//                .collect(Collectors.toList());
//    }

    @Override
    public Optional<AuthorisedPersonEntity> getAuthorisedPersonById(Long id) {
        Optional<AuthorisedPersonEntity> authorisedPersonEntity = authorisedPersonRepository.findById(id);
        return authorisedPersonEntity;
    }

    @Override
    public String updateAuthorisedPersonById(AuthorisedPersonModel authorisedPersonModel, Long id) {
        return String.valueOf(authorisedPersonRepository.findById(id)
                .map(topic -> {
                    topic.setPersonName(authorisedPersonModel.getPersonName());
                    topic.setDescription(authorisedPersonModel.getDescription());
                    topic.setEmailAddress(authorisedPersonModel.getEmailAddress());
                    topic.setPhoneNumber(authorisedPersonModel.getPhoneNumber());
                    topic.setNidNumber(authorisedPersonModel.getNidNumber());
                    topic.setSignature(authorisedPersonModel.getSignature().getOriginalFilename());
                    return authorisedPersonRepository.save(topic);
                }));

    }


}
