package com.netit.vendor.policy;

public class AccessPolicy {
	
	private boolean isAuthenticatable;
	private boolean isRolePolicyCompaund;
	private UserRoles[] roleCollection;

	public AccessPolicy() {
		this.isAuthenticatable 	= false;
	}	
	
	public AccessPolicy(boolean isAuthenticatable) {
		this.isAuthenticatable 	= isAuthenticatable;
	}

	public AccessPolicy(boolean isRolePolicyCompaund, UserRoles ...roleCollection) {

		this.isAuthenticatable 		= true;
		this.isRolePolicyCompaund 	= isRolePolicyCompaund; 
		this.roleCollection 		= roleCollection;
	}
	
	public boolean isAuthenticatable() {
		return isAuthenticatable;
	}
	
	public boolean areRolesAvailable() {

		// TODO ... next time
		return false;
	}
}
