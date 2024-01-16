package com.bugtracker.employeemodule.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddEmployeeDto {
	@NotNull
	private String empName;
	
	@NotNull
	private String empEmail;
	
	@NotNull
	private String empContact;
}
