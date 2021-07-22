package com.netit.vendor.policy;

public enum UserRoleEnum {
	USER, MODERATOR, ADMIN;
	
	public static UserRoleEnum promote(int index) {

		if(index == 1) return UserRoleEnum.USER;		
		if(index == 2) return UserRoleEnum.MODERATOR;
		if(index == 3) return UserRoleEnum.ADMIN;
		
		return null;
	}
	
}
