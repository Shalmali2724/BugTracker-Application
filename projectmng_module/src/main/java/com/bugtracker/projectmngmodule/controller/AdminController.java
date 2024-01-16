package com.bugtracker.projectmngmodule.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 

import com.bugtracker.projectmngmodule.dto.AdminDto;
import com.bugtracker.projectmngmodule.dto.AssignDto;
import com.bugtracker.projectmngmodule.service.AdminService;

 

@RestController
@RequestMapping("/admin/ctr")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/save")
    public ResponseEntity<AdminDto> addAdmin(@RequestBody AdminDto adminDto)
    {
        AdminDto newAdminDto=adminService.saveAdmin(adminDto);
        ResponseEntity<AdminDto> responseEntity = new ResponseEntity<>(newAdminDto, HttpStatus.CREATED);
        return responseEntity;    
    }
    @PostMapping("/assgn")
    public ResponseEntity<?> assigningPrject(@RequestBody AssignDto assignDto){
        adminService.assigningProject(assignDto);
        return null;

    }
	

}
