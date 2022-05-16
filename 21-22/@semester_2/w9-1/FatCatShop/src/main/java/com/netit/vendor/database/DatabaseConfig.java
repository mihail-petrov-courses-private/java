package com.netit.vendor.database;

import java.util.Properties;

public class DatabaseConfig {

	public static final String DRIVER 	= "mysql";
	public static final String PORT 	= "3306";
	public static final String SCHEMA 	= "fat_cat";
	public static final String USER 	= "root";
	public static final String PASSWORD = "";
	
	public static String getUrl() {
		return "jdbc:" 			+  
				DRIVER 			+ 
				"://localhost:" + 
				PORT 			+ 
				"/" 			+ 
				SCHEMA;
	}
	
	public static Properties getCredentials() {
		
        Properties credentials = new Properties();
        if (USER 		!= null) credentials.put("user", USER);
        if (PASSWORD 	!= null) credentials.put("password", PASSWORD);
        
        return credentials;
	}
	
	public static String colString(String column) {
		return "'" + column + "'";
	}
}
