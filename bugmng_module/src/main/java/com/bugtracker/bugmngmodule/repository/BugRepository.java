package com.bugtracker.bugmngmodule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugtracker.bugmngmodule.entity.Bugs;

@Repository
public interface BugRepository extends JpaRepository<Bugs, Long>{

	 
}
