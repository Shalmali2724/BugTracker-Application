package com.bugtracker.employeemodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugtracker.employeemodule.entity.Bugs;

@Repository
public interface BugRepository extends JpaRepository<Bugs, Long> {

}
