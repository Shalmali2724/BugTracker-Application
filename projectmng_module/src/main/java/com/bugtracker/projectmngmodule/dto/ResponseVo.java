package com.bugtracker.projectmngmodule.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.bugtracker.projectmngmodule.entity.Employee;
import com.bugtracker.projectmngmodule.entity.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVo {
	
	private List<Employee> employee;
	
	@NotNull
	private Project project;

}
