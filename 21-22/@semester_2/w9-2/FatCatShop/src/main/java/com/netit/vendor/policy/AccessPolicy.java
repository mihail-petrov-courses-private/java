package com.netit.vendor.policy;

public class AccessPolicy {
	
	private boolean isAuthenticatable;
	private boolean isRolePolicyCompaund;
	private UserRoleEnum[] roleCollection;

	public AccessPolicy() {
		this.isAuthenticatable 	= false;
	}	
	
	public AccessPolicy(boolean isAuthenticatable) {
		this.isAuthenticatable 	= isAuthenticatable;
	}

	public AccessPolicy(boolean isRolePolicyCompaund, UserRoleEnum ...roleCollection) {

		this.isAuthenticatable 		= true;
		this.isRolePolicyCompaund 	= isRolePolicyCompaund; 
		this.roleCollection 		= roleCollection;
	}
	
	public boolean isAuthenticatable() {
		return isAuthenticatable;
	}
	
	
	public boolean isPublic() {
		return this.isAuthenticatable == false;
	}
	
	
	public boolean isRoleInRoleCollection(UserRoleEnum roleId, UserRoleEnum[] collection) {
		
		for(int i = 0; i < collection.length; i++) {

			if(roleId == collection[i]) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean hasRoles(UserRoleEnum[] presentedRoleCollection) {

		if(presentedRoleCollection == null) {
			return false;
		}
		
		if(this.isRolePolicyCompaund) {
			for(int i = 0; i < this.roleCollection.length; i++) {
				UserRoleEnum role = this.roleCollection[i];
				if(!this.isRoleInRoleCollection(role, presentedRoleCollection)) return false;
			}	
			
			return true;
		}
		
		for(int i = 0; i < this.roleCollection.length; i++) {
			UserRoleEnum role = presentedRoleCollection[i];
			if(this.isRoleInRoleCollection(role, presentedRoleCollection)) return true;
		}
		
		return false;
	}
	
	
}
