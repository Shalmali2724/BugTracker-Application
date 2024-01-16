package com.bugtracker.employeemodule.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bugtracker.employeemodule.dto.AddEmployeeDto;
import com.bugtracker.employeemodule.dto.BugUpdateDto;
import com.bugtracker.employeemodule.entity.Bugs;
import com.bugtracker.employeemodule.entity.Employee;
import com.bugtracker.employeemodule.entity.Project;

import com.bugtracker.employeemodule.exception.EmployeeNotFoundException;
import com.bugtracker.employeemodule.repository.BugRepository;
import com.bugtracker.employeemodule.repository.EmployeeRepository;
import com.bugtracker.employeemodule.repository.ProjectRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private BugRepository bugRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	// Here we are saving all the records of employee which created
	
	public Employee createEmployee(AddEmployeeDto employee) {

		Employee newEmployee = new Employee(); // Create new Employee
		newEmployee.setEmpName(employee.getEmpName());
		newEmployee.setEmpEmail(employee.getEmpEmail());
		newEmployee.setEmpContact(employee.getEmpContact());
		employeeRepository.save(newEmployee);
		return newEmployee;
		
	}

	// Here we are getting all the records of employee by id
	public Optional<Employee> getEmployeeById(long id) throws EmployeeNotFoundException {
		Optional<Employee> employee = employeeRepository.findById((long) id);
		if (!employee.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with ID: " + id);
		}
		return employee;
	}

	// Here we are updating all the records of employee by id
	
	public void updateemployeeById(Employee employee) throws EmployeeNotFoundException {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEmpId());
		if (!optionalEmployee.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with ID: " + employee.getEmpId());
		}
		employeeRepository.save(employee);
	}

	// Here we are deleting all the records of employee by id
	public void deleteEmployeeById(Employee employee) throws EmployeeNotFoundException {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEmpId());
		if (!optionalEmployee.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with ID: " + employee.getEmpId());
		}
		employeeRepository.delete(employee);
	}

	// Here we are getting all the records of employee which created
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	// Here we are changing the Bug status and End Date
	public void updateBugStatus(long bugId, BugUpdateDto bugupdatedto) {

		

		Bugs bug = bugRepository.findById(bugId).get();
		bug.setStatus(bugupdatedto.getStatus());
		bug.setProgress(bugupdatedto.getProgress());
		bug.setEndDate(Date.valueOf(LocalDate.now()));
		bugRepository.save(bug);

	}
	
	public List<Project> getAllProjectByEmpId(long empId)
	{
		
		List<Project> project =(List<Project>) restTemplate.getForEntity("http://project-module/proj/projectByEmployeeId/"+empId,List.class);
		
		return project;
	}


}
