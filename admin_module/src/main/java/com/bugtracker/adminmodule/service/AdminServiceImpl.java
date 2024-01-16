package com.bugtracker.adminmodule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bugtracker.adminmodule.dto.AdminDto;
import com.bugtracker.adminmodule.dto.AssignDto;
import com.bugtracker.adminmodule.dto.Employee;
import com.bugtracker.adminmodule.dto.Project;
import com.bugtracker.adminmodule.entity.Admin;
import com.bugtracker.adminmodule.entity.AdminLoginTable;
import com.bugtracker.adminmodule.exception.AdminAuthenticationFailureException;
import com.bugtracker.adminmodule.exception.AdminNotFoundException;
import com.bugtracker.adminmodule.exception.EmployeeNotFoundException;
import com.bugtracker.adminmodule.exception.ProjectNotFoundException;
import com.bugtracker.adminmodule.repository.AdminRepository;
import com.bugtracker.adminmodule.repository.UserTableRepository;;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private AdminRepository adminRepositroy;

	@Autowired
	private UserTableRepository userTableRepo;

	@Override
	public String addAdmin(AdminDto adminDto) {
		Admin admin = new Admin();
		Optional<Admin> adminOptional = adminRepositroy.getByAdminEmail(adminDto.getAdminEmail());
		if (adminOptional.isPresent()) {
			throw new AdminAuthenticationFailureException("Admin is already Registered with this email Id");
		}

		admin.setAdminName(adminDto.getAdminName());
		admin.setAdminEmail(adminDto.getAdminEmail());
		admin.setAdminContact(adminDto.getAdminContact());
		admin.setAdminAddress(adminDto.getAdminAddress());
		admin.setRole(adminDto.getRole());
		adminRepositroy.save(admin);

		AdminLoginTable userTable = new AdminLoginTable();
		userTable.setPassword(adminDto.getPassword());
		userTable.setUserName(adminDto.getAdminEmail());
		userTable.setRole(adminDto.getRole());
		userTableRepo.save(userTable);

		return "Admin saved successfully";
	}

	@Override
	public Admin doLogin(String userName, String password, String role) {

		Optional<AdminLoginTable> optionalAdmin = userTableRepo.login(userName, password, role);
		if (optionalAdmin.isEmpty()) {
			throw new AdminNotFoundException("Admin not existing");
		}
		AdminLoginTable newUserTable = optionalAdmin.get();
		if (!(password.equals(newUserTable.getPassword()) && newUserTable.getRole().equals(role)
				&& newUserTable.getUserName().equals(userName))) {
			throw new AdminAuthenticationFailureException("login failed !! Enter correct credential ..");
		}

		Optional<Admin> admin = adminRepositroy.getByAdminEmail(userName);
		if (admin.isEmpty()) {
			throw new AdminAuthenticationFailureException("Data Not Found For perticulat UserName");
		}
		Admin newAdmin = admin.get();
		return newAdmin;
	}

	@Override
	public Admin updateAdmin(Admin admin) {

		Optional<Admin> optionalAdmin = adminRepositroy.findById(admin.getId());
		if (optionalAdmin.isEmpty()) {
			throw new AdminNotFoundException("Admin not existing with id:" + admin.getId());
		}
		Admin updatedAdmin = adminRepositroy.save(admin);
		return updatedAdmin;

	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> obj = (List<Employee>) restTemplate
				.getForObject("http://employee-module/api/emp/employee/getall", List.class);
		if (obj.isEmpty()) {
			throw new EmployeeNotFoundException("Employee does Not Exists in database right now!!");

		}

		return obj;
	}

	@Override
	public List<Project> getAllProject() {
		List<Project> project = restTemplate.getForObject("http://project-module/proj/project/all", List.class);
		if (project.isEmpty()) {
			throw new ProjectNotFoundException("Project Not Exists in database right now.Check after sometime!!");

		}

		return project;
	}

	@Override
	public void assignEmplToProj(AssignDto assignDto) {
		restTemplate.postForObject("http://project-module/admin/ctr/assgn", assignDto, Void.class);

	}

}
