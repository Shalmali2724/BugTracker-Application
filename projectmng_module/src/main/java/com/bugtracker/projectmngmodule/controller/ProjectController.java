package com.bugtracker.projectmngmodule.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracker.projectmngmodule.dto.ProjectDto;
import com.bugtracker.projectmngmodule.dto.ResponseVo;
import com.bugtracker.projectmngmodule.dto.UpdateProjectDto;
import com.bugtracker.projectmngmodule.entity.Employee;
import com.bugtracker.projectmngmodule.entity.Project;
import com.bugtracker.projectmngmodule.service.ProjectService;

@RestController
@RequestMapping("/proj")
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@PostMapping("/project/save")
	public ResponseEntity<String> addProject(@Valid @RequestBody ProjectDto projectDto) {
		ProjectDto savedProject = projectService.addProject(projectDto);
		return ResponseEntity.status(HttpStatus.OK).body("Project saved successfully!");

	}

	@PutMapping("/project/update/{projectId}")
	public ResponseEntity<Project> modifyProject(@PathVariable("projectId")long projectId,@RequestBody UpdateProjectDto updateProject) {
		Project updatedProject = projectService.updateProjectById(updateProject, projectId);
		ResponseEntity<Project> responseEntity = new ResponseEntity<>(updatedProject, HttpStatus.OK);
		return responseEntity;

	}

	@GetMapping("/project/all")
	public ResponseEntity<List<Project>> fetchAllProjects() {
		List<Project> list = projectService.getAllProject();
		
		ResponseEntity<List<Project>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/project/{projectid}")
	public ResponseVo fetchProjectDetails(@PathVariable("projectid") @Valid long projectId) {

		ResponseVo obj = projectService.getProjectById(projectId);

		return obj;
	}
	
	
	
	@GetMapping("/projectByEmployeeId/{empId}")
 public ResponseEntity<List<Project>>fetchProjectDetailsByEmployeeId(@PathVariable("empId") long empId) {

	List<Project> project = projectService.getProjectByEmployeeId(empId);
	
	ResponseEntity<List<Project>> responseEntity = new ResponseEntity<>(project, HttpStatus.OK);
	return  responseEntity ;
}

}




















