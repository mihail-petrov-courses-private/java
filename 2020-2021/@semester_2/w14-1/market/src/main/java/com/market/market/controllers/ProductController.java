package com.market.market.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.ArrayList;
import java.util.HashMap;

import com.market.market.exceptions.CustomSpringException;
import com.market.market.handlers.CustomResponse;
import com.market.market.models.Product;
import com.market.market.services.implementations.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	// List all products
	// READ - GET
	@GetMapping("/")
	public ArrayList<Product> getAllProducts() {
		return this.service.getAll();
	}
	
	// List specific product
	// READ - GET
	@GetMapping("/{id}")
	public Product getSingleProduct(
			@PathVariable("id") int id
	) throws CustomSpringException {
		
		Product productReference = this.service.get(id);
		if(productReference != null) {
			return productReference;
		}
		
		throw new CustomSpringException();
	}
	
	// Create new product
	// CREATE - POST
	@PostMapping("/")
	public ResponseEntity<?> createNewProduct(
	 @RequestBody Product entity
	) throws CustomSpringException {
		
		if(this.service.isValid(entity)) {
			this.service.add(entity);
			return CustomResponse.send("Successfuly added new entity to collection", entity);
		}
		
		throw new CustomSpringException();
	}
	
	// Update existing product
	// UPDATE - PUT
	@PutMapping("/{id}")
	public ResponseEntity<?> updateProduct(
			@PathVariable int id, 
			@RequestBody Product entity
	) throws CustomSpringException {
		
		try {
			var updatedEntity = this.service.update(id, entity);
			return CustomResponse.send("Successfuly updated existing entity", updatedEntity);
		}
		catch (Exception e) {
			throw new CustomSpringException();
		}
	}
	
	// Remove existing product
	// DELETE - DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removeProduct(
		@PathVariable int id
	) throws CustomSpringException {
		
		try {
			this.service.remove(id);
			return CustomResponse.send("Successfuly remove existing entity");
		}
		catch (Exception e) {
			throw new CustomSpringException();
		}
	}
	
	@ExceptionHandler(CustomSpringException.class)
	public HashMap<String, String> customHandler() {

		HashMap<String, String> httpResponse = new HashMap<>();
		httpResponse.put("status", "FAIL");
		httpResponse.put("message", "Exception handling");
		return httpResponse;
	}
}
