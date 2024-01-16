package com.bugtracker.customermodule.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugtracker.customermodule.entities.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{

}
