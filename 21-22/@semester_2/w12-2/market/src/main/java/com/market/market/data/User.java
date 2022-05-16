package com.market.market.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
	
	@Autowired
	private LoginPolicy policy;
	
	public void login() {
		this.policy.login();
	}
}
