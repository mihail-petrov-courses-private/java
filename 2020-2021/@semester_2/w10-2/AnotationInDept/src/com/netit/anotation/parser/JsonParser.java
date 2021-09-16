package com.netit.anotation.parser;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.netit.anotation.labels.JsonProperty;
import com.netit.anotation.labels.Jsonable;

public class JsonParser {

	public String stringify(Object object) 
			throws Exception {
		
		// Get all properties
		Class objectReferenceClass 					= object.getClass();
		if(!isJsonable(objectReferenceClass)) {
			throw new Exception("This class cannot be JSON stringify");
		}
				
		Field[] objectReferenceClassFieldCollection =  objectReferenceClass.getDeclaredFields();
		
		// Instance of new HashMap
		HashMap<String, String> jsonStringPlaceholder = new HashMap<>();
		
		
		for(Field classField : objectReferenceClassFieldCollection) {
			
			if(this.isParsable(classField)) {
				
				classField.setAccessible(true);
				String alternativeName 	= classField.getDeclaredAnnotation(JsonProperty.class).alternativeName();
				String jsonKey 			= alternativeName.equals("") ? classField.getName() : alternativeName;   
				Object jsonValue 		= classField.get(object);
				jsonStringPlaceholder.put(jsonKey, String.valueOf(jsonValue));	
			}
		}
		
		// Return String JSON representation
		return buildStringOutput(jsonStringPlaceholder);
	}
	
	private boolean isParsable(Field classField) {
		return classField.isAnnotationPresent(JsonProperty.class);
	}
	
	private boolean isJsonable(Class reference) {
		return reference.isAnnotationPresent(Jsonable.class);
	}
	
	
	private String buildStringOutput(HashMap<String, String> jsonObject) {
		
		Set<String> keyCollection = jsonObject.keySet();
		StringBuilder resultJsonStringArrayBuilder = new StringBuilder();
		
		resultJsonStringArrayBuilder.append("{");
		for(String element : keyCollection) {
			String value = jsonObject.get(element);
			
			resultJsonStringArrayBuilder.append("\"" + element + "\""  + ":" + "\"" + value + "\"" + ",");
		}

		resultJsonStringArrayBuilder.deleteCharAt(resultJsonStringArrayBuilder.length() - 1);
		resultJsonStringArrayBuilder.append("}");
		
		return resultJsonStringArrayBuilder.toString();
	}
	
}
