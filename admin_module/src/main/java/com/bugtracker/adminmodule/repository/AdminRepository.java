package com.bugtracker.adminmodule.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugtracker.adminmodule.entity.Admin;

@Repository
public interface AdminRepository  extends JpaRepository<Admin,Long>{
	Optional<Admin> getByAdminEmail(String adminEmail);

}
