package com.vat.bmitvat.controller.auth;

import com.vat.bmitvat.entity.UserEntity;
import com.vat.bmitvat.model.SignInRequest;
import com.vat.bmitvat.model.SignUpRequest;
import com.vat.bmitvat.model.UnitsModel;
import com.vat.bmitvat.model.UserModel;
import com.vat.bmitvat.service.JwtService;
import com.vat.bmitvat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bmitvat/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private static final String UPLOAD_DIR = "D:\\Java\\BMIT\\bmitvatjava\\frontend\\public\\assets\\images\\users";
    @GetMapping("/welcome")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

//    @RequestBody
//    , consumes = {   "multipart/form-data" }
@PostMapping(value = "/register" )
public String addUser(@ModelAttribute SignUpRequest signUpRequest) {

        System.out.println(signUpRequest.getNidScan().getOriginalFilename());
//        System.out.println(signUpRequest.getProfileImage().getOriginalFilename());

        var file = signUpRequest.getNidScan();
        var file2 = signUpRequest.getProfileImage();

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        String NidName = file.getOriginalFilename();
        File ndestFile = new File(uploadDir.getAbsolutePath() + File.separator + NidName);

        String profileName = file2.getOriginalFilename();
        File pdestFile = new File(uploadDir.getAbsolutePath() + File.separator + profileName);

        try {
        file.transferTo(ndestFile);
        file2.transferTo(pdestFile);
        } catch (IOException e) {
        throw new RuntimeException(e);
        }

        signUpRequest.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        return userService.addUser(signUpRequest);
}


    @GetMapping("/all_user")
     public List<UserModel> getusers(){
            return userService.getAllUsers();
    }


//    @PostMapping("/signup")
//    public ResponseEntity<JwtAuthResponse> signup(@RequestBody SignUpRequest request) {
//        return ResponseEntity.ok(userService.signup(request));
//    }

    @GetMapping(path="/get_user/{id}")
    public ResponseEntity<Optional<UserEntity>> getUserById(@PathVariable Long id){
        Optional<UserEntity> userEntity=userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userEntity);
    }


    @PutMapping("/update_user/{id}")
    public String updateUserById(@ModelAttribute SignUpRequest signUpRequest, @PathVariable Long id) {
//        System.out.println(signUpRequest.getProfileImage().getOriginalFilename());
//        var file = signUpRequest.getNidScan();
        var file2 = signUpRequest.getProfileImage();

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
//        String NidName = file.getOriginalFilename();
//        File ndestFile = new File(uploadDir.getAbsolutePath() + File.separator + NidName);

        String profileName = file2.getOriginalFilename();
        File pdestFile = new File(uploadDir.getAbsolutePath() + File.separator + profileName);

        try {
//            file.transferTo(ndestFile);
            file2.transferTo(pdestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return userService.updateUserById(signUpRequest, id);
//        System.out.println(userEntityReq);
//        return ResponseEntity.ok().body(userEntityReq);
    }
}
