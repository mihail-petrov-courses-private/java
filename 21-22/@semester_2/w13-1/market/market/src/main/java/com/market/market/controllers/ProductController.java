package com.market.market.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.ArrayList;
import java.util.HashMap;

import com.market.market.exceptions.CustomSpringException;
import com.market.market.models.Product;
import com.market.market.services.implementations.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	// List all products
	// READ - GET
	@RequestMapping(
			value="/", 
			method = RequestMethod.GET
	)
	public ArrayList<Product> getAllProducts() {
		return this.service.getAll();
	}
	
	// List specific product
	// READ - GET
	@GetMapping("/{id}")
	public Product getSingleProduct(@PathVariable("id") int id) 
			// throws NoHandlerFoundException 
			   throws CustomSpringException {
		
		Product productReference = this.service.get(id);
		if(productReference != null) {
			return productReference;
		}
		
		// throw new NoHandlerFoundException("GET", "/test/{id}", null);
		throw new CustomSpringException();
	}
	
	// Create new product
	// CREATE - POST
	public void createNewProduct(Product entity) {
		
	}
	
	// Update existing product
	// UPDATE - PUT
	public void updateProduct(int id, Product updatedEntity) {
		
	}
	
	// Remove existing product
	// DELETE - DELETE
	public void removeProduct(int id) {
		
	}
	
	@ExceptionHandler(CustomSpringException.class)
	public HashMap<String, String> customHandler() {

		HashMap<String, String> httpResponse = new HashMap<>();
		httpResponse.put("status", "FAIL");
		httpResponse.put("message", "Exception handling");
		return httpResponse;
	}
}
