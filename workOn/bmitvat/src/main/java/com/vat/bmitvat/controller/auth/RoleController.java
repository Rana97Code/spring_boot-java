package com.vat.bmitvat.controller.auth;

import com.vat.bmitvat.model.RoleModel;
import com.vat.bmitvat.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bmitvat/api")
@CrossOrigin("*")
public class RoleController {
    private final RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService){
        this.roleService=roleService;
    }

    @PostMapping("/add-role")
    public ResponseEntity<RoleModel> saveSingleRole(@RequestBody RoleModel roleModel){
        RoleModel roleModelRes=roleService.saveSingleRole(roleModel);
        return ResponseEntity.ok().body(roleModelRes);
    }
}
