package com.market.market.data;

import org.springframework.stereotype.Component;

@Component
public class StandartPolicy implements LoginPolicy {

	@Override
	public void login() {
		System.out.println(" Default policy");
	}
}
