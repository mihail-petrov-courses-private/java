package com.market.market.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.market.handlers.CustomResponse;
import com.market.market.models.Customer;
import com.market.market.services.repository.CustomerRepository;

@RestController()
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository service;
	
	@GetMapping("/")
	public List<Customer> getAllCustomers() {
		return this.service.findAll();
	}
	
	@GetMapping("/{id}")
	public Customer getAllCustomers(@PathVariable("id") int id) {
		return this.service.findById(id).get();
	}
	
	@GetMapping("/email/{id}")
	public Customer getCustomerByEmail(@PathVariable("id") String emailId) {
		return this.service.findByEmail(emailId);
	}
	
//	@GetMapping("/error/{id}")
//	public Customer doNotGetEnithing(@PathVariable("id") String something) {
//		return this.service.notMappableMethodName(something);
//	}
	
	@PostMapping("/")
	public ResponseEntity<?> createNewCustomer(
		@RequestBody Customer request
	) {
		this.service.save(request);
		return CustomResponse.send("New customer is created");
	}
}
