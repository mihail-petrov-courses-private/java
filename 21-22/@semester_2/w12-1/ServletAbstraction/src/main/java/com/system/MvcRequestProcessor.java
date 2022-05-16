package com.system;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import com.anotations.MvcController;
import com.scanner.EntityScanner;

public class MvcRequestProcessor {

	private static HashMap<String, HashMap<String,ControllerMethodPare>> controllerMap;
	private static ArrayList<Class> controllerCollection;
		
	public static void processMvcRequest(MvcRequest request) 
			throws ClassNotFoundException		, 
					NoSuchMethodException		, 
					SecurityException			, 
					InstantiationException		, 
					IllegalAccessException		, 
					IllegalArgumentException	, 
					InvocationTargetException 	{
		
		// Scann all controllers 
		var collection = parseController();
		loadController(request.getController(), request.getMethod());
	}
	
	private static HashMap<String, HashMap<String,ControllerMethodPare>> parseController() {
		
		if(controllerMap != null) {
			return controllerMap;
		}
		
		try {
			ArrayList<Class> controllerCollection = scannControllerCollection();
			controllerMap = new HashMap<String, HashMap<String,ControllerMethodPare>>();
			
			for(Class controller : controllerCollection) {
				if(controller.isAnnotationPresent(com.anotations.MvcController.class)) {
					var anotation 		 	= controller.getAnnotation(com.anotations.MvcController.class);
					String controllerUrl 	= ((MvcController) anotation).url();
					var controllerMethodMap = parseMethodRelation(controller);
					controllerMap.put(controllerUrl, controllerMethodMap);
				}
			}

		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return controllerMap;
	}
	
	private static HashMap<String, ControllerMethodPare> parseMethodRelation(Class controller) {
		
		Method[] methodCollection = controller.getDeclaredMethods();
		var collection = new HashMap<String,ControllerMethodPare>(); 
		
		for(Method controllerMethod : methodCollection) {
			if(controllerMethod.isAnnotationPresent(com.anotations.MvcMethod.class)) {
				String methodUrl = controllerMethod.getAnnotation(com.anotations.MvcMethod.class).url();
				collection.put(methodUrl, new ControllerMethodPare(controller, controllerMethod));
			}
		}
		
		return collection;
	}
	
	
	private static  ArrayList<Class> scannControllerCollection() 
			throws ClassNotFoundException, IOException {
		
		if(controllerCollection != null) {
			return controllerCollection;
		}
		
		controllerCollection = EntityScanner.scannPackage("com.controllers");
		return controllerCollection;
	}
	

	private static void loadController(String requestController, String requestMethod) 
			throws 	ClassNotFoundException		, 
					NoSuchMethodException		, 
					SecurityException			, 
					InstantiationException		, 
					IllegalAccessException		, 
					IllegalArgumentException	, 
					InvocationTargetException 	{
		
		var controllerMethodCollection 	= controllerMap.get(requestController);
		var mvcPare 					= controllerMethodCollection.get(requestMethod);
		Class classReference 			= mvcPare.getController();
		Method classReferenceMethod 	= mvcPare.getMethod();
		Object controllerInstrance 		= classReference.getConstructor().newInstance();
		classReferenceMethod.invoke(controllerInstrance);
		
//		Class<?> classReference 	=  Class.forName(requestController);
//		Method classReferenceMethod =  classReference.getMethod(requestMethod, null);
//		
//		Object controllerInstrance 	= classReference.getConstructor().newInstance();
//		classReferenceMethod.invoke(controllerInstrance);
	}
	
	
	
}
