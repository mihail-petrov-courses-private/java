package com.system;

import javax.servlet.http.HttpServletRequest;

public class MvcRequestParser {

	public static MvcRequest parse(HttpServletRequest req) {
		
		String requestUrl 				= req.getPathInfo();
		String[] urlSegmentCollection 	= requestUrl.split("/");
		String requestController 		= getController(urlSegmentCollection); 
		String requestMethod 			= getMethod(urlSegmentCollection);
		return new MvcRequest(requestController, requestMethod);
	}
	
	private static String getController(String[] urlSegmentCollection) {
		
		try {
			return urlSegmentCollection[1];
		}
		catch(Exception e) {
			return "NotFound";
		}
	}
	
	private static String getMethod(String[] urlSegmentCollection) {
		
		try {
			return urlSegmentCollection[2];
		}
		catch(Exception e) {
			return "index";
		}
	}	
}
