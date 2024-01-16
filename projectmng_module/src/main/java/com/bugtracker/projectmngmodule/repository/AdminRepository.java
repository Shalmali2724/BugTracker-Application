package com.bugtracker.projectmngmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugtracker.projectmngmodule.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{

}
