package com.market.market.handlers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomResponse {

	public static ResponseEntity<Object> send(String message) {
	
		HashMap<String, Object> httpResponse = new HashMap<>();
		httpResponse.put("message"		, message);
		
		return new ResponseEntity<Object>(httpResponse, HttpStatus.OK);
	}
	
	public static ResponseEntity<Object> send(String message, HttpStatus code) {
		
		HashMap<String, Object> httpResponse = new HashMap<>();
		httpResponse.put("message"		, message);
		
		return new ResponseEntity<Object>(httpResponse, code);
	}	

	public static ResponseEntity<Object> send(String message, Object collection) {
		
		HashMap<String, Object> httpResponse = new HashMap<>();
		httpResponse.put("message"		, message);
		httpResponse.put("collection"	, collection);
		
		return new ResponseEntity<Object>(httpResponse, HttpStatus.OK);
	}	
	
	public static ResponseEntity<Object> send(String message, Object collection, HttpStatus code) {
		
		HashMap<String, Object> httpResponse = new HashMap<>();
		httpResponse.put("message"		, message);
		httpResponse.put("collection"		, collection);
		
		return new ResponseEntity<Object>(httpResponse, code);
	}	
}
