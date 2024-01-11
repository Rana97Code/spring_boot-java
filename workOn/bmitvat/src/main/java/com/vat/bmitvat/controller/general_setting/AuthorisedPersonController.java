package com.vat.bmitvat.controller.general_setting;
import com.vat.bmitvat.entity.AuthorisedPersonEntity;
import com.vat.bmitvat.model.AuthorisedPersonModel;
import com.vat.bmitvat.service.AuthorisedPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class AuthorisedPersonController {
    private final AuthorisedPersonService authorisedPersonService;
    private static final String UPLOAD_DIR = "D:\\Java\\BMIT\\bmitvatjava\\frontend\\public\\assets\\images\\authorised_person";

    @Autowired
    public AuthorisedPersonController(AuthorisedPersonService authorisedPersonService) {
        this.authorisedPersonService = authorisedPersonService;
    }


    @PostMapping("/authorised_person/add-person")
    public String saveSingleperson(@ModelAttribute AuthorisedPersonModel authorisedPersonModel){
        var file1 = authorisedPersonModel.getSignature();

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        String LoginLogo = file1.getOriginalFilename();
        File ndestFile = new File(uploadDir.getAbsolutePath() + File.separator + LoginLogo);


        try {
            file1.transferTo(ndestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


      return authorisedPersonService.saveSinglePerson(authorisedPersonModel);
    }

    @GetMapping("/authorised_person/all_person")
    public List<AuthorisedPersonEntity> getAllPerson(){
        return authorisedPersonService.getAllPerson();
    }

    @GetMapping(path="/authorised_person/get_person/{id}")
    public ResponseEntity<Optional<AuthorisedPersonEntity>> getCostingById(@PathVariable Long id){
        Optional<AuthorisedPersonEntity> authorisedPersonEntity=authorisedPersonService.getAuthorisedPersonById(id);
        return ResponseEntity.status(HttpStatus.OK).body(authorisedPersonEntity);
    }

    @PutMapping("/authorised_person/update_person/{id}")
    public String updateCostignById(@ModelAttribute AuthorisedPersonModel authorisedPersonModel, @PathVariable Long id) {
        var file1 = authorisedPersonModel.getSignature();
        if(!file1.isEmpty()) {
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            String LoginLogo = file1.getOriginalFilename();
            File ndestFile = new File(uploadDir.getAbsolutePath() + File.separator + LoginLogo);

            try {
                file1.transferTo(ndestFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return authorisedPersonService.updateAuthorisedPersonById(authorisedPersonModel, id);

    }


}
