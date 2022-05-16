package com.netit.anotation;

import com.netit.anotation.model.Product;
import com.netit.anotation.model.Student;
import com.netit.anotation.parser.JsonParser;

public class Application {

	public static void main(String[] args) {
		
		try {
			
			JsonParser parser 	= new JsonParser();
			String json = parser.stringify(new Product("Sony Tv", 1500, "Tv", "black", true));
			System.out.println(json);
			
			String json2 = parser.stringify(new Product("LG", 1000, "Smartphone", "white", false));
			System.out.println(json2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
