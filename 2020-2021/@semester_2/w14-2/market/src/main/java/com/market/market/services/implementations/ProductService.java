package com.market.market.services.implementations;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.market.market.models.Product;
import com.market.market.services.interfaces.IRepository;

@Component
public class ProductService implements IRepository<Product> {

	private ArrayList<Product> collection;
	private int lastInsertedId;
	
	public ProductService() {
		
		this.lastInsertedId = -1;
		
		this.collection = new ArrayList<>();
//		this.collection.add(new Product(1, 2999	, "IPhone"			, "phone"));
//		this.collection.add(new Product(2, 50	, "Nokia"			, "phone"));
//		this.collection.add(new Product(3, 1999	, "Samsung Galaxy"	, "phone"));
//		this.collection.add(new Product(4, 500	, "Sony Ericson"	, "phone"));
//		this.collection.add(new Product(5, 120	, "NEO"				, "TV"));
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

	@Override
	public void add(Product element) {
		
		element.setId(this.getNextId());
		this.collection.add(element);
	}
	
	private int getNextId() {
		
		if(this.lastInsertedId != -1) {
			return this.lastInsertedId++;
		}
		
		this.collection.size(); // 5 
		Product entity = this.collection.get(this.collection.size() - 1);
		this.lastInsertedId = (entity.getId() + 1); 
		return this.lastInsertedId;
	}

	@Override
	public boolean isValid(Product element) {

		return element.getPrice() 		!= 0 &&
				element.getCategory() 	!= null &&
						element.getTitle() 	!= null;
	}

	@Override
	public Product update(int id, Product element) throws Exception {
		
		int collectionIndex = getCollectionIndexById(id);
				
		if(collectionIndex == -1) {
			throw new Exception("Element not found");
		}
		
		element.setId(id);
		this.collection.set(collectionIndex, element);
		return element;
	}

	@Override
	public void remove(int id) throws Exception {
		
		int collectionIndex = getCollectionIndexById(id);
		
		if(collectionIndex == -1) {
			throw new Exception("Element not found");
		}
		
		this.collection.remove(collectionIndex);
	}
	
	
	private int getCollectionIndexById(int id) {

		int collectionIndex = -1;
		for(int i = 0; i < this.collection.size(); i++) {
			if(this.collection.get(i).getId() == id) {
				collectionIndex = i;
			}
		}
		
		return collectionIndex;
	}
}
