package com.controllers;

import com.anotations.MvcController;

public class NotFound extends AppController {

	@Override
	public void index() {
		System.out.print("404 Controller not found exception");
	}
}
