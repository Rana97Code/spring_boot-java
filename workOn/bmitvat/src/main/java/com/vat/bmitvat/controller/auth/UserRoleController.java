package com.vat.bmitvat.controller.auth;

import com.vat.bmitvat.model.UserRoleModel;
import com.vat.bmitvat.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class UserRoleController {
    private final UserRoleService userRoleService;
    @Autowired
    public UserRoleController(UserRoleService userRoleService){
        this.userRoleService=userRoleService;
    }

    @PostMapping("/add-user-role")
    public ResponseEntity<UserRoleModel> saveSingleUserRole(@RequestBody UserRoleModel permissionModel){
        UserRoleModel userRoleModelRes=userRoleService.saveSingleUserRole(permissionModel);
        return ResponseEntity.ok().body(userRoleModelRes);
    }
}
