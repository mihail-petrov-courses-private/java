package com.system;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/*")
public class FrontController extends HttpServlet {
	
	@Override
	protected void doGet(
			HttpServletRequest req, 
			HttpServletResponse resp
			) throws ServletException, IOException {
		
		try {
			MvcRequest request = MvcRequestParser.parse(req);
			MvcRequestProcessor.processMvcRequest(request);
		} catch (	ClassNotFoundException 		| 
				 	NoSuchMethodException 		| 
				 	SecurityException 			| 
				 	InstantiationException		| 
				 	IllegalAccessException 		| 
				 	IllegalArgumentException 	| 
				 	InvocationTargetException e1) {
			e1.printStackTrace();
		}
	}
}
