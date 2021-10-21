package com.trelloclone.trelloclone.wrappers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseMessage {

	public static ResponseEntity success() {
		return buildHttpResponse(HttpStatus.OK, null, null);
	}

	public static ResponseEntity success(String message) {
		return buildHttpResponse(HttpStatus.OK, message, null);
	}	
	
	public static ResponseEntity success(String message, Object data) {
		return buildHttpResponse(HttpStatus.OK, message, data);
	}		
	
	public static ResponseEntity success(Object data) {
		return buildHttpResponse(HttpStatus.OK, null, data);
	}
	
	public static ResponseEntity notFound() {
		return buildHttpResponse(HttpStatus.OK, null, null);
	}
	
	public static ResponseEntity notFound(String message) {
		return buildHttpResponse(HttpStatus.OK, message, null);
	}	
	
	private static HashMap<String, Object> buildHttpMessage(HttpStatus status, String message, Object data) {
		
		HashMap<String, Object> httpReponse = new HashMap<>();
		String httpResponseMessage 			= message != null 
											? message : 
											  status.getReasonPhrase();

		httpReponse.put("message"	, httpResponseMessage);
		httpReponse.put("status"	, status.value());
		
		if(data != null) {
			httpReponse.put("collection", data);	
		}
		
		return httpReponse;
	}
	
	
	private static ResponseEntity buildHttpResponse(HttpStatus status, String message, Object data) {
		
		var httpResponse = buildHttpMessage(status, message, data);
		return ResponseEntity.status(status).body(httpResponse);
	}
}
