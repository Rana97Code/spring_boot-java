package com.example.spring_mvn.controller;

import com.example.spring_mvn.dto.AccessDTO;
import com.example.spring_mvn.dto.RoleModel;
import com.example.spring_mvn.dto.UserDTO;
import com.example.spring_mvn.entity.User;
import com.example.spring_mvn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/get_user")
    public List<User> getUsers(){

        return userService.getUsers();
    }

    @GetMapping("/get_one")
    public User getOne(@RequestParam Long id){

        return userService.getOne(id);
    }

    @PutMapping("/update_user/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody User user){
        userService.updateUser(id, user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete_user/{id}")
    public ResponseEntity<Void>deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/update_name/{id}")
    public ResponseEntity<Void> updateName(@PathVariable Long id, @RequestBody UserDTO userDTO){
        userService.updateName(id, userDTO);

        return ResponseEntity.noContent().build();
    }

    //Join Table and insert data to both table
//    @PostMapping("/user_access")
//    public User CreateUserAccess(@RequestBody AccessDTO accessDTO){
//        return userService.CreateUserAccess(accessDTO);
//    }

//    //Get Join query Data Directly
//    @GetMapping("/get_user_access")
//    public List<UserAccessDTO> getUserAccess(){
//        return userRepository.getUserAccess();
//    }


}
