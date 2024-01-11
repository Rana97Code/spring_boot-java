package com.vat.bmitvat.controller.auth;

import com.vat.bmitvat.model.PermissionModel;
import com.vat.bmitvat.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class PermissionController {
    private final PermissionService permissionService;
    @Autowired
    public PermissionController(PermissionService permissionService){
        this.permissionService=permissionService;
    }

    @PostMapping("/add-permission")
    public ResponseEntity<PermissionModel> saveSinglePermission(@RequestBody PermissionModel permissionModel){
        PermissionModel permissionModelRes=permissionService.saveSinglePermission(permissionModel);
        return ResponseEntity.ok().body(permissionModelRes);
    }
}
