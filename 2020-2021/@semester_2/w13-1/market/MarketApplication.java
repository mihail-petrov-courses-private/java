package com.market.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.market.market.data.User;

@SpringBootApplication
public class MarketApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(MarketApplication.class, args);
	}
}
