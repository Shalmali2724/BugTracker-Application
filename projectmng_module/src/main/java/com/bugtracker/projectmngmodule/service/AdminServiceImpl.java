package com.bugtracker.projectmngmodule.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugtracker.projectmngmodule.dto.AdminDto;
import com.bugtracker.projectmngmodule.dto.AssignDto;
import com.bugtracker.projectmngmodule.dto.ProjectDto;
import com.bugtracker.projectmngmodule.entity.Admin;
import com.bugtracker.projectmngmodule.entity.Employee;
import com.bugtracker.projectmngmodule.entity.Project;
import com.bugtracker.projectmngmodule.exception.ProjectNotFoundException;
import com.bugtracker.projectmngmodule.repository.AdminRepository;
import com.bugtracker.projectmngmodule.repository.EmployeeRepository;
import com.bugtracker.projectmngmodule.repository.ProjectRepository;
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ProjectService projectService;

	@Override
	public AdminDto saveAdmin(AdminDto adminDto) {
		Admin admin = new Admin();
		admin.setAdminName(adminDto.getAdminName());
	    admin.setAdminContact(adminDto.getAdminContact());
	    admin.setAdminEmail(adminDto.getAdminEmail());
	    admin.setAdminAddress(adminDto.getAdminAddress());
	    
	    
	    
	    Admin savedAdmin = adminRepository.save(admin);
		
	    AdminDto savedAdminDto = new AdminDto();
	    
	    savedAdminDto.setAdminName(savedAdmin.getAdminName());
	    savedAdminDto.setAdminAddress(savedAdmin.getAdminAddress());
	    savedAdminDto.setAdminContact(savedAdmin.getAdminContact());
	    savedAdminDto.setAdminEmail(savedAdmin.getAdminEmail());
	    
	    
	    return savedAdminDto;
	}

	@Override
	public ProjectDto addProject(ProjectDto projectDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assigningProject(AssignDto assignDto) {
		Optional<Project> optProj =  projectRepository.findById(assignDto.projId);
		if(optProj.isEmpty()) {
			throw new ProjectNotFoundException("project not found.");
		}
		Project proj = optProj.get();
		
		
		Optional<Employee> optEmp =  employeeRepository.findById(assignDto.empId);
		if(optEmp.isEmpty()) {
			throw new ProjectNotFoundException("employee not found.");
		}
		Employee empl = optEmp.get();
		
		List<Employee> empList = new ArrayList<>();
		empList.add(empl);
		
		
		//Update project
		proj.setProjStatus("Open");
		proj.setEmployee(empList);
		projectRepository.save(proj);
		
		
		//Employee Update
		empl.setProjId(assignDto.projId);
		employeeRepository.save(empl);
	}

	
	

}
