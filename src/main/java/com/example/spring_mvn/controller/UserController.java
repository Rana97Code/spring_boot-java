package com.example.spring_mvn.controller;

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

    @PostMapping("/add_user")
    public String addUser(@RequestBody User user){
        userService.addUser(user);

        return "Successfully Add User";
    }

    @GetMapping("/get_user")
    public List<User> getUsers(){

        return userService.getUsers();
    }

    @GetMapping("/get_one")
    public User getOne(@RequestParam Integer id){

        return userService.getOne(id);
    }

    @PutMapping("/update_user/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody User user){
        userService.updateUser(id, user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete_user/{id}")
    public ResponseEntity<Void>deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/update_name/{id}")
    public ResponseEntity<Void> updateName(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        userService.updateName(id, userDTO);

        return ResponseEntity.noContent().build();
    }
}
