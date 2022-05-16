package com.market.market.services.implementations;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.market.market.models.Product;
import com.market.market.services.interfaces.IRepository;

@Component
public class ProductService implements IRepository<Product> {

	private ArrayList<Product> collection;
	
	public ProductService() {
		this.collection = new ArrayList<>();
		this.collection.add(new Product(1, 2999	, "IPhone"			, "phone"));
		this.collection.add(new Product(2, 50	, "Nokia"			, "phone"));
		this.collection.add(new Product(3, 1999	, "Samsung Galaxy"	, "phone"));
		this.collection.add(new Product(4, 500	, "Sony Ericson"	, "phone"));
		this.collection.add(new Product(5, 120	, "NEO"				, "TV"));
	}
	
	@Override
	public ArrayList<Product> getAll() {
		return this.collection;
	}

	@Override
	public Product get(int id) {
		
		for(Product element : this.collection) {
			if(element.getId() == id) {
				return element;
			}
		}
		
		return null;
	}

}
