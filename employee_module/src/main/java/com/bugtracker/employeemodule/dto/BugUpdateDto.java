package com.bugtracker.employeemodule.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BugUpdateDto {
	
	

	private String status;
	private int progress;
	

}
