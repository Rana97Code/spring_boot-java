package com.vat.bmitvat.controller.auth;

import com.vat.bmitvat.model.UserPermissionModel;
import com.vat.bmitvat.service.UserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class UserPermissionController {
    private final UserPermissionService userPermissionService;
    @Autowired
    public UserPermissionController(UserPermissionService userPermissionService){
        this.userPermissionService=userPermissionService;
    }

    @PostMapping("/add-user-permission")
    public ResponseEntity<UserPermissionModel> saveSingleUserPermission(@RequestBody UserPermissionModel userPermissionModel){
        UserPermissionModel userPermissionModelRes=userPermissionService.saveSingleUserPermission(userPermissionModel);
        return ResponseEntity.ok().body(userPermissionModelRes);
    }
}
