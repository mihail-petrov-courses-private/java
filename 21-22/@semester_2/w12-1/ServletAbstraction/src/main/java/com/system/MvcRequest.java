package com.system;

import java.util.HashMap;

public class MvcRequest {

	// /home/index?limit=10
	private String controller;
	private String method;
	private HashMap<String, String> queryParameters;

	public MvcRequest(String controller) {
		this(controller, "index", new HashMap<String, String>());
	}
	
	public MvcRequest(String controller, String method) {
		this(controller, method, new HashMap<String, String>());
	}
	
	public MvcRequest(String controller, String method, HashMap<String, String> queryParameters) {
		this.controller 		= controller;
		this.method 			= method;
		this.queryParameters 	= queryParameters;
	}
	
	public String getController() {
		return this.controller;
	}
	
	public String getMethod() {
		return this.method;
	}	
	
	public HashMap<String, String> getQueryParameters() {
		return this.queryParameters;
	}
}
