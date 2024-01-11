package com.vat.bmitvat.service.impl;

import com.vat.bmitvat.entity.UserEntity;
import com.vat.bmitvat.model.*;
import com.vat.bmitvat.repository.UserRepository;
import com.vat.bmitvat.service.JwtService;
import com.vat.bmitvat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@Service
@RequiredArgsConstructor
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;


    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return (UserDetails) userRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

//@Override
//public String addUser(SignUpRequest signUpRequest) {
//    UserEntity userEntity= UsersMapper.MAPPER.modelToEntity(signUpRequest);
//    userRepository.save(userEntity);
//    return "Successfully Insert";
//}
@Override
public String addUser(SignUpRequest signUpRequest) {
    var user = UserEntity.builder()
            .username(signUpRequest.getUsername())
            .userEmail(signUpRequest.getUserEmail())
            .userPhone(signUpRequest.getUserPhone())
            .firstName(signUpRequest.getFirstName())
            .lastName(signUpRequest.getLastName())
            .userNid(signUpRequest.getUserNid())
            .nidScan(signUpRequest.getNidScan().getOriginalFilename())
            .password(signUpRequest.getPassword())
            .profileImage(signUpRequest.getProfileImage().getOriginalFilename())
            .saleCenterId(signUpRequest.getSaleCenterId())
            .userType(signUpRequest.getUserType())
            .status(signUpRequest.getStatus())
            .createdBy(signUpRequest.getCreatedBy())
            .updatedBy(signUpRequest.getUpdatedBy())
            .build();
//    System.out.println(user.getProfileImage());
    userRepository.save(user);
    return "Successfully Insert";
}

//    @Override
//    public JwtAuthResponse signup(SignUpRequest request) {
//        var user = UserEntity.builder()
//                .userName(request.getUserName())
//                .userEmail(request.getUserEmail())
//                .userPassword(passwordEncoder.encode(request.getUserPassword()));
//        System.out.println(user);
////        userRepository.save(user);
//        var jwt = jwtService.generateToken((UserDetails) user);
//        return JwtAuthResponse.builder().token(jwt).build();
//    }

    @Override
    public String usersignin(SignInRequest signInRequest) {

        TokenModel tokenModel = userRepository.getUserDetails(signInRequest.getUsername());
//        System.out.println(tokenModel);

        var user = userRepository.findByUsername(signInRequest.getUsername());
        System.out.println(user.stream().count());
        var uu = user.stream().count();
        if(isNotEmpty(uu)){
            return jwtService.generateToken(tokenModel);
        } else {
            throw new UsernameNotFoundException("Invalid Email OR Password !");
        }

    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll().stream().map(user -> {
            UserModel userModel = new UserModel();
            userModel.setId(user.getId());
            userModel.setUsername(user.getUsername());
            userModel.setUserEmail(user.getUserEmail());
//            userModel.setStatus(user.getStatus());
//            userModel.setCreatedBy(user.getCreatedBy());
            return userModel;
        }).collect(Collectors.toList());
    }




    @Override
    public Optional<UserEntity> getUserById(Long id){
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity;
    }


    @Override
    public String updateUserById(SignUpRequest signUpRequest, Long id) {

//        System.out.println(signUpRequest.getFirstName());
        return String.valueOf(userRepository.findById(id)
                .map(topic -> {
                    topic.setFirstName(signUpRequest.getFirstName());
                    topic.setLastName(signUpRequest.getLastName());
                    topic.setUserEmail(signUpRequest.getUserEmail());
                    topic.setUserPhone(signUpRequest.getUserPhone());
                    topic.setProfileImage(signUpRequest.getProfileImage().getOriginalFilename());
                    return userRepository.save(topic);
                }));
    }

}
