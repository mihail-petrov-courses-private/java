package com.market.market.models;

public class Product {

	private int id;
	private double price;
	private String title;
	private String category;
	
	public Product(int id, double price, String title, String category) {
		this.id 		= id;
		this.price 		= price;
		this.title 		= title;
		this.category 	= category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
