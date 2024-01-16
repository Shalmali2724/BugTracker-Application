package com.bugtracker.projectmngmodule.dto;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProjectDto {
			
		
		
		@NotNull(message = "Project name is required")
		private String projectName;
		
		@NotNull(message = "Project status is required")
		private String projectStatus;
	

}
