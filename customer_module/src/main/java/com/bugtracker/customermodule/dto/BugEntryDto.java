package com.bugtracker.customermodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BugEntryDto {
	private String title;
	private String description;
	private String type;
	private String priority;
	private String projectName;
	private int customerId;
}
