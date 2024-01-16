package com.bugtracker.adminmodule.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracker.adminmodule.dto.AdminDto;
import com.bugtracker.adminmodule.dto.AdminLoginDto;
import com.bugtracker.adminmodule.dto.AssignDto;
import com.bugtracker.adminmodule.dto.Employee;
import com.bugtracker.adminmodule.dto.Project;
import com.bugtracker.adminmodule.entity.Admin;
import com.bugtracker.adminmodule.entity.AdminLoginTable;
import com.bugtracker.adminmodule.service.AdminService;

@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {
	@Autowired
	private AdminService adminService;

	@PostMapping("/save")
	public ResponseEntity<String> addAdmin(@Valid @RequestBody AdminDto adminDto) {
		String newAdminDto = adminService.addAdmin(adminDto);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(newAdminDto, HttpStatus.OK);
		return responseEntity;

	}

	@PostMapping("/login")
	public ResponseEntity<?> adminLogin(@Valid @RequestBody AdminLoginDto userTable) {

		Admin admin = adminService.doLogin(userTable.getUserName(), userTable.getPassword(), userTable.getRole());

		return ResponseEntity.status(HttpStatus.OK).body("Admin login successfully!");

	}

	@PutMapping("/update")
	public ResponseEntity<Admin> modifyAdmin(@Valid @RequestBody Admin admin) {
		Admin updatedAdmin = adminService.updateAdmin(admin);
		ResponseEntity<Admin> responseEntity = new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/viewEmployees")
	public List<Employee> getEmployee() {
		List<Employee> list = adminService.getAllEmployee();
		return list;
	}

	@GetMapping("/getAllProject")
	public List<Project> getAllProject() {
		List<Project> proj = adminService.getAllProject();

		return proj;

	}

	@PostMapping("/AssignEmpl")
	public void assignEmplToProj(@RequestBody AssignDto assignDto) {
		adminService.assignEmplToProj(assignDto);

	}
}
