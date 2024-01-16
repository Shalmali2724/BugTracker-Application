package com.bugtracker.projectmngmodule.service;



import java.util.List;


import com.bugtracker.projectmngmodule.dto.ProjectDto;
import com.bugtracker.projectmngmodule.dto.ResponseVo;
import com.bugtracker.projectmngmodule.dto.UpdateProjectDto;
import com.bugtracker.projectmngmodule.entity.Project;


public interface ProjectService {
	public ProjectDto addProject(ProjectDto projectDto);
	
	public Project updateProjectById(UpdateProjectDto updateProject, long projectId);
	public ResponseVo getProjectById(long projectId);
	public List<Project> getAllProject();
	public List<Project> getProjectByEmployeeId(long empId);
	
}

























//tryyy
//void createProject(ProjectDto projectDto);