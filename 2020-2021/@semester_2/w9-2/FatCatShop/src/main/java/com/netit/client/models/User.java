package com.netit.client.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.netit.vendor.database.Database;
import com.netit.vendor.database.DatabaseConfig;
import com.netit.vendor.policy.UserRoleEnum;

public class User {
	
	public static String TABLE 			= "td_users";
	public static String ID 			= "id";
	public static String USER_EMAIL 	= "user_email";
	public static String USER_PASSWORD 	= "user_password";
	public static String USER_NAME 		= "user_name";
	public static String FIRST_NAME 	= "first_name";
	public static String LAST_NAME 		= "last_name";
	public static String AGE 			= "age";
	public static String CITY 			= "city";
	public static String ADDRESS 		= "address";
	

	public static boolean doesExists(String userEmail, String userPass) {

		int userCount = Database.getInstance()
		.where(USER_EMAIL		, DatabaseConfig.colString(userEmail))
		.andWhere(USER_PASSWORD	, DatabaseConfig.colString(userPass))
		.count(TABLE);
		
		return userCount == 1;
	}
	
	
	public static ResultSet get(String userEmail, String userPass) {

		return Database.getInstance()
				.where(USER_EMAIL		, DatabaseConfig.colString(userEmail))
				.andWhere(USER_PASSWORD	, DatabaseConfig.colString(userPass))
				.select(TABLE, "id");
	}
	
	
	public static UserRoleEnum[] getRoles(String userEmail, String userPass) {

		ResultSet roleCollection = Database.getInstance()
		.where("a.id"					, "b.user_id")
		.andWhere("c.id"				, "b.role_id")
		.andWhere("a.user_email"		, DatabaseConfig.colString(userEmail))
		.andWhere("a.user_password"		, DatabaseConfig.colString(userPass))
		.select(new String[] { "td_users a", "td_user__role b", "tm_roles c" }, 
				new String[] { "c.id" });
		
		try {
			
			ArrayList<UserRoleEnum> resultCollection = new ArrayList<>();
			while(roleCollection.next()) {
				resultCollection.add(
						UserRoleEnum.promote(roleCollection.getInt("id"))
				);
			}
			
			UserRoleEnum[] collection = new UserRoleEnum[resultCollection.size()];
			for(int i = 0; i < resultCollection.size(); i++ ) {
				collection[i] = resultCollection.get(i);
			}			
			
			return collection;
			
		} catch (SQLException e) {
		e.printStackTrace();
	}		
	
	return null;
		
		
		
		
//		ResultSet userCollection = get(userEmail, userPass);
//		
//		try {
//			userCollection.next();
//			int userId = userCollection.getInt("id");
//			
//			ResultSet roleCollection = Database.getInstance()
//			.where("user_id", userId + "")
//			.select("td_user__role", "role_id");
//			
//			ArrayList<Integer> resultCollection = new ArrayList<>();
//			while(roleCollection.next()) {
//				resultCollection.add(roleCollection.getInt("role_id"));
//			}
//			
//			UserRoleEnum[] collection = new UserRoleEnum[resultCollection.size()];
//			for(int i = 0; i < resultCollection.size(); i++ ) {
//				
//				if(resultCollection.get(i) == 1) {
//					collection[i]	 = UserRoleEnum.USER;
//				}
//				
//				if(resultCollection.get(i) == 2) {
//					collection[i]	 = UserRoleEnum.MODERATOR;
//				}				
//				
//				if(resultCollection.get(i) == 3) {
//					collection[i]	 = UserRoleEnum.ADMIN;
//				}
//			}
//			
//			return collection;
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//		
//		return null;		
	}
}
