package com.vat.bmitvat.service;

import com.vat.bmitvat.entity.AuthorisedPersonEntity;
import com.vat.bmitvat.model.AuthorisedPersonModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface AuthorisedPersonService {
    String saveSinglePerson(AuthorisedPersonModel authorisedPersonModel);

    List<AuthorisedPersonEntity> getAllPerson();

    Optional<AuthorisedPersonEntity> getAuthorisedPersonById(Long id);

    String updateAuthorisedPersonById(AuthorisedPersonModel authorisedPersonModel, Long id);

}
