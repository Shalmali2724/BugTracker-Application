package com.bugtracker.employeemodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugtracker.employeemodule.entity.Bugs;
import com.bugtracker.employeemodule.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	void save(Bugs bugs1);


//	Employee findByEmail(String email);

}
