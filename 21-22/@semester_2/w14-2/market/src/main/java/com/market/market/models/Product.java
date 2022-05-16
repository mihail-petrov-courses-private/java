package com.market.market.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_products")
public class Product {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double price;
	private String title;
	private String category;
	
	// принадлежи на customer
	@ManyToOne
	private Customer customer;
	
	public Product(double price, String title, String category, Customer customer) {
		this.price 		= price;
		this.title 		= title;
		this.category 	= category;
		
		// Установявам връзка между Customer обекта и текущия Product
		this.customer = customer;
	}
	
	public Product() {
		
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
