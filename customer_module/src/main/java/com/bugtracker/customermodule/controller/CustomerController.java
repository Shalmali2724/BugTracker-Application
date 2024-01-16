package com.bugtracker.customermodule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracker.customermodule.dto.BugEntryDto;
import com.bugtracker.customermodule.entities.Bugs;
import com.bugtracker.customermodule.entities.CustomerEntity;
import com.bugtracker.customermodule.service.CustomerService;

@RestController
@RequestMapping("/Customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/addCustomer")
	public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customer,  String password) {
		return new ResponseEntity<CustomerEntity>(customerService.createCustomer(customer, password), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable("id") int customerId,
			@RequestBody CustomerEntity updatedCustomer) {
		return new ResponseEntity<CustomerEntity>(customerService.updateCustomer(customerId, updatedCustomer),
				HttpStatus.OK);
	}

	@GetMapping("get/{id}")
	public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable("id") int custId) {
		return new ResponseEntity<CustomerEntity>(customerService.getCustomerById(custId), HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<CustomerEntity>> getAllCustomer() {
		List<CustomerEntity> customers = customerService.getAllCustomers();
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable("id") int customerId) {
		return new ResponseEntity<String>(customerService.deleteCustomer(customerId), HttpStatus.OK);
	}
	
	@PostMapping("/create-bug")
	public ResponseEntity<?> addBug(@RequestBody BugEntryDto bug){
		customerService.addBug( bug);
		return null;
	}
	
	 @GetMapping("/findAllBugs/{custId}")
	    public List<Bugs> getAllBugsByCustId(@PathVariable("custId") int custId)
	    {
	        List<Bugs> bugs= customerService.getAllBugsByCustId(custId);
	        return bugs;
	    }
}
