package com.bugtracker.customermodule.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bugs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bugId;
	
	@NotNull
	private String title;
	
	@NotNull
	private String description;
	
	@NotNull
	private String type;
	
	@NotNull
	private String priority;
	
	
	private int progress;
	
	@OneToOne
	private Employee employee;
	
	
	private String status;
	
	@NotNull
	private Date startDate;
	
	
	private Date endDate;
	
	@ManyToOne
	private Project project;
	
	@ManyToOne
	private CustomerEntity customerEntity;
}
