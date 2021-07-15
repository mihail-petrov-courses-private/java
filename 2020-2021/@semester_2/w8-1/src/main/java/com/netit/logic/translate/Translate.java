package com.netit.logic.translate;

public class Translate {

	public static final String LOGIN_FAILD = "LOGIN_FAILD"; 
	
	
	public static String get(String key, String langKey) {
		
		if(key.equals(LOGIN_FAILD)) {
			if(langKey == "en") {
				return "User not found in the database"; 
			}
			
			if(langKey == "bg") {
				return "Потребителя не е намерен в системата";
			}
		}
		
		return key;
	}
}
