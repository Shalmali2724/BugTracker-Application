package com.bugtracker.employeemodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugtracker.employeemodule.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
