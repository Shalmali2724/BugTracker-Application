package com.bugtracker.adminmodule.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bugtracker.adminmodule.entity.Admin;
import com.bugtracker.adminmodule.entity.AdminLoginTable;



public interface UserTableRepository extends JpaRepository<AdminLoginTable,Long> {
	@Query("select a from AdminLoginTable a where a.userName = :aname and a.password = :pwd and a.role = :role")
	Optional<AdminLoginTable> login(@Param("aname") String Username, @Param("pwd") String Password,@Param("role") String role);

}
