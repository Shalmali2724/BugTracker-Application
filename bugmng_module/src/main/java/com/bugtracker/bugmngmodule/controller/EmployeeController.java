package com.bugtracker.bugmngmodule.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracker.bugmngmodule.entity.Employee;

@RestController
@RequestMapping("/api/bugmng/empcnt")
public class EmployeeController {
	
	//Create Employee
	@PostMapping("/create-employee")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
		return null;
	}
}
