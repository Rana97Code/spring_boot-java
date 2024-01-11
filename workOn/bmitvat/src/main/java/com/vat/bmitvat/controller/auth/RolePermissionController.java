package com.vat.bmitvat.controller.auth;

import com.vat.bmitvat.model.RolePermissionModel;
import com.vat.bmitvat.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class RolePermissionController {
    private final RolePermissionService rolePermissionService;

    @Autowired
    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @PostMapping("/add-role-permission")
    public ResponseEntity<RolePermissionModel> saveSingleRolePermission(@RequestBody RolePermissionModel rolePermissionModel){
        RolePermissionModel roleModelRes=rolePermissionService.saveSingleRolePermission(rolePermissionModel);
        return ResponseEntity.ok().body(roleModelRes);
    }
}
