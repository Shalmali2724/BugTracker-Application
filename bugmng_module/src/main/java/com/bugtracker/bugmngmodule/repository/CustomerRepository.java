package com.bugtracker.bugmngmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugtracker.bugmngmodule.entity.CustomerEntity;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {

}
