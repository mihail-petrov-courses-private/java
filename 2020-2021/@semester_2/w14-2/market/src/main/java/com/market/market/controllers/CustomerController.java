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
import com.market.market.models.Product;
import com.market.market.services.repository.CustomerRepository;
import com.market.market.services.repository.ProductRepository;

@RestController()
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository service;
	
	@Autowired
	private ProductRepository productService;
	
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
	
	@GetMapping("/fullname/{firstname}/{lastname}")
	public List<Customer> getCustomerByFullname(
			@PathVariable("firstname") String firstName,
			@PathVariable("lastname") String lastName
	) {
		return this.service.findByFullName(firstName, lastName);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> createNewCustomer(
		@RequestBody Customer request
	) {
		this.service.save(request);
		return CustomResponse.send("New customer is created");
	}
	
	
	@GetMapping("/attach/{userid}")
	public void attachProducts(
			@PathVariable("userid") int id
	) {
		Customer customer = this.service.getById(id);
		this.productService.save(new Product(19, "Печка", "техника", customer));
		this.productService.save(new Product(29, "Пералня", "техника", customer));
		this.productService.save(new Product(39, "Бойлер", "техника", customer));
	}
	
	@GetMapping("/getattach/{userid}")
	public List<Product> getAttachedProducts(
			@PathVariable("userid") int id
	) {
		Customer customer = this.service.getById(id);
		return customer.getProducts();
	}
}
