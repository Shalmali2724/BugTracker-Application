package com.bugtracker.customermodule.service;

import java.util.List;

import com.bugtracker.customermodule.dto.BugEntryDto;
import com.bugtracker.customermodule.entities.Bugs;
import com.bugtracker.customermodule.entities.CustomerEntity;

public interface CustomerService {
	
	 CustomerEntity createCustomer(CustomerEntity customer, String password);
	 CustomerEntity updateCustomer(int id, CustomerEntity updatedCustomer);
	 String deleteCustomer(int id);
	 CustomerEntity getCustomerById(int id);
	 List<CustomerEntity> getAllCustomers();
	void addBug(BugEntryDto bug);
	List<Bugs> getAllBugsByCustId(int custId);
	

}
