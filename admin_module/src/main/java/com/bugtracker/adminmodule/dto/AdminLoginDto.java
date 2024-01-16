package com.bugtracker.adminmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminLoginDto {
	
	
	private String userName;
	private String password;
	private String role;
	

}