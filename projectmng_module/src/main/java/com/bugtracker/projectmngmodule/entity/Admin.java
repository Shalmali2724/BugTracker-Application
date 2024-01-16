package com.bugtracker.projectmngmodule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Admin_Entity")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
    @NotNull(message = "Name required")
	private String adminName;
     @NotNull(message = "a")
	private String adminAddress;
     @NotNull
	private String adminContact;
     @NotNull
	private String adminEmail;
     @NotNull
	private String role;



}
