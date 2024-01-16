package com.bugtracker.customermodule.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bugtracker.customermodule.dto.BugEntryDto;
import com.bugtracker.customermodule.entities.Bugs;
import com.bugtracker.customermodule.entities.CustomerEntity;
import com.bugtracker.customermodule.entities.UserEntity;
import com.bugtracker.customermodule.exception.CustomerNotFoundException;
import com.bugtracker.customermodule.repo.CustomerRepo;
import com.bugtracker.customermodule.repo.UserRepo;
import com.bugtracker.customermodule.service.CustomerService;

@Service
public class CustomerImpl implements CustomerService{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
    public CustomerEntity createCustomer(CustomerEntity customer, String password) {
        
        String email = customer.getEmail(); // Check if customer exists by email
        CustomerEntity existingCustomer = customerRepo.findByEmail(email);
        if (existingCustomer != null) {
            throw new IllegalArgumentException("Customer with email " + email + " already exists.");
        }

        
        CustomerEntity newCustomer = new CustomerEntity();  // Create new customer
        newCustomer.setCustomerName(customer.getCustomerName());
        newCustomer.setEmail(email);
        customerRepo.save(newCustomer);

        
        UserEntity newUser = new UserEntity();  // Create user entity with the same details as the customer
        newUser.setUserName(customer.getCustomerName());
        newUser.setUserEmail(email);
        newUser.setPassword(password);
        userRepo.save(newUser);

        return newCustomer;
    }
	
	@Override
	public CustomerEntity updateCustomer(int id, CustomerEntity updatedCustomer) {
	    Optional<CustomerEntity> optionalCustomer = customerRepo.findById(id);
	    Optional<UserEntity> optionalUser = userRepo.findById(id);

	    if (optionalCustomer.isPresent()) {
	        CustomerEntity existingCustomer = optionalCustomer.get();
	        existingCustomer.setCustomerName(updatedCustomer.getCustomerName()); // Update the fields of the existing customer
	        existingCustomer.setEmail(updatedCustomer.getEmail());

	        if (optionalUser.isPresent()) {
	            UserEntity user = optionalUser.get(); // Update the corresponding UserEntity
	            user.setUserName(updatedCustomer.getCustomerName());
	            user.setUserEmail(updatedCustomer.getEmail());
	        } else {
	            throw new CustomerNotFoundException("User not found with id: " + id);
	        }

	        return customerRepo.save(existingCustomer);

	    } else {
	        throw new CustomerNotFoundException("Customer not found with id: " + id);
	    }
	}



	 @Override
	 public String deleteCustomer(int id) {
	     Optional<CustomerEntity> optionalCustomer = customerRepo.findById(id);
	     Optional<UserEntity> optionalUser=userRepo.findById(id);

	     
	     if (optionalCustomer.isPresent()) {
	    	 CustomerEntity customer = optionalCustomer.get();
	         customerRepo.delete(customer);
	         
	         if(optionalUser.isPresent()) {
	        	 UserEntity user = optionalUser.get();
	        	 userRepo.delete(user);
	         }else {
		            throw new CustomerNotFoundException("User not found with id: " + id);
		        }
	         
	         return "Customer deleted successfully";
	     } else {
	         throw new CustomerNotFoundException("Customer not found with id: " + id);
	     }
	 }

	 @Override
	 public CustomerEntity getCustomerById(int id) {
	     Optional<CustomerEntity> optionalCustomer = customerRepo.findById(id);

	     if (optionalCustomer.isPresent()) {
	         return optionalCustomer.get();
	     } else {
	         throw new CustomerNotFoundException("Customer not found with id: " + id);
	     }
	 }


	 @Override
	 public List<CustomerEntity> getAllCustomers() {
	     return customerRepo.findAll();
	 }

	@Override
	public void addBug(BugEntryDto bug) {
		String url="http://bugmng-module/api/bugmng/create-bug";
		this.restTemplate.postForObject(url, bug, String.class);
	}

	@Override
	public List<Bugs> getAllBugsByCustId(int custId) {
		List<Bugs> bugs = restTemplate.getForObject("http://bugmng-module/api/bugmng/bugcustid/"+custId, List.class);
		return bugs;
	}



}