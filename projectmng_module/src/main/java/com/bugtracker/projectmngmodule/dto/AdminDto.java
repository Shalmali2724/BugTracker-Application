package com.bugtracker.projectmngmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
	private String adminName;
	private String adminAddress;
	private String adminContact;
	private String adminEmail;

}
