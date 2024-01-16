package com.bugtracker.projectmngmodule.service;

import org.springframework.stereotype.Service;

import com.bugtracker.projectmngmodule.dto.AdminDto;
import com.bugtracker.projectmngmodule.dto.AssignDto;
import com.bugtracker.projectmngmodule.dto.ProjectDto;

@Service
public interface AdminService {
	AdminDto saveAdmin(AdminDto adminDto);
	public ProjectDto addProject(ProjectDto projectDto);
	void assigningProject(AssignDto assignDto);
	
	
	

}
