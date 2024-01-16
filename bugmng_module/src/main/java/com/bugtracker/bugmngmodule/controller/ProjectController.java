package com.bugtracker.bugmngmodule.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracker.bugmngmodule.entity.Project;

@RestController
@RequestMapping("/api/bugmng/projcnt")
public class ProjectController {
	//Create Project
		@PostMapping("/create-project")
		public ResponseEntity<?> createProject(@RequestBody Project projrct){
			return null;
		}
}
