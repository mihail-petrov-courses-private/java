package com.market.market.data;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DigitalPolicy implements LoginPolicy {

	@Override
	public void login() {
		System.out.println("*** DIGITAL POLICY LOGIN *** ");
	}
}
