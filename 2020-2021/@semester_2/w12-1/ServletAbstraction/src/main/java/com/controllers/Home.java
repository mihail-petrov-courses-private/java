package com.controllers;

import com.anotations.MvcController;
import com.anotations.MvcMethod;

@MvcController(url="home")
public class Home extends AppController {

	public void init() {
		System.out.print("Init Home Controller");
	}

	@Override
	public void index() {
		System.out.print("Index page");
	}
	
	@MvcMethod(url="show")
	public void showMarketInformation() {
		System.out.print("Custom MVC request method");
	}
}
