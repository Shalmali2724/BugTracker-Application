package com.bugtracker.adminmodule.service;

import java.util.List;

import com.bugtracker.adminmodule.dto.AdminDto;
import com.bugtracker.adminmodule.dto.AssignDto;
import com.bugtracker.adminmodule.dto.Employee;
import com.bugtracker.adminmodule.dto.Project;
import com.bugtracker.adminmodule.entity.Admin;
import com.bugtracker.adminmodule.entity.AdminLoginTable;

public interface AdminService {
	//Method for Admin registration 
	public String addAdmin(AdminDto adminDto);
	
	//Method For Admin Login
	public Admin doLogin(String userName,String password,String role);
	
	//Method update
	public Admin updateAdmin(Admin admin);

	public List<Employee> getAllEmployee();

	public List<Project> getAllProject();

	public void assignEmplToProj(AssignDto assignDto);
	
	

}
