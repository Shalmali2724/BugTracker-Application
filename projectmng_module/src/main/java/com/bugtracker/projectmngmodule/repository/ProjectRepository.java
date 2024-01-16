package com.bugtracker.projectmngmodule.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugtracker.projectmngmodule.entity.Employee;
import com.bugtracker.projectmngmodule.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{

	List<Project> findByemployee(Employee emp);

}