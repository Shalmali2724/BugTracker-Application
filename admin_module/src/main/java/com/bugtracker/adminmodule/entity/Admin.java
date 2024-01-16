package com.bugtracker.adminmodule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Admin_Entity")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Name is required")
	private String adminName;
	
	@NotNull(message = "Admin address is required")
	private String adminAddress;
	@NotNull(message = "Admin contact is required")

	@Pattern(regexp = "\\d{10}", message = "Contact number must be a 10-digit number")
	private String adminContact;
	@NotNull(message = "Admin Email is required")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email format")
	@Size(max = 100, message = "Email must be up to 100 characters")
	private String adminEmail;
	@NotNull(message = "Role is required")
	private String role;

}
