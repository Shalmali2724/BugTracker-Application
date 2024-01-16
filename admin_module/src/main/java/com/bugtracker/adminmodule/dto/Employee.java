package com.bugtracker.adminmodule.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@NotNull
	private String empName;
	
	@NotNull
	private String empEmail;
	
	@NotNull
	private String empContact;
}
