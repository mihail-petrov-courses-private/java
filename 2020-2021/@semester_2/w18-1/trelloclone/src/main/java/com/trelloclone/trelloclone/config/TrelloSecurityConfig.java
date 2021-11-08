package com.trelloclone.trelloclone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class TrelloSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private TrelloAuthenticationProvider authenticationProvider; 
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(this.authenticationProvider.provide());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/style/**").permitAll()
			.antMatchers("/signup", "/").anonymous()
			.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/signin").usernameParameter("email")
				.permitAll().defaultSuccessUrl("/dashboard")
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"));
	}
}
