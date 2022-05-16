package com.netit.anotation.model;

import com.netit.anotation.labels.JsonProperty;
import com.netit.anotation.labels.Jsonable;

@Jsonable
public class Product {

	@JsonProperty(alternativeName = "product_title")
	private String title;
	
	@JsonProperty(alternativeName = "best_price")
	private double price;
	
	@JsonProperty()
	private String category;
	
	@JsonProperty()
	private String color;
	
	private boolean isAvailable;
	
	private boolean isAccountable;
	
	public Product(String title, double price, String category, String color, boolean isAvailable) {
		this.title = title;
		this.price = price;
		this.category = category;
		this.color = color;
		this.isAvailable = isAvailable;
	}
	
	
}

// Product p = new Product("Sony Tv", 1500, "Tv", "black", true);
// {"title": "Sony Tv", "price": 1500, category: "Tv", color: "black"}