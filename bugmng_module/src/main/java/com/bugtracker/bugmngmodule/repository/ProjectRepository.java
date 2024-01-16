package com.bugtracker.bugmngmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugtracker.bugmngmodule.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
