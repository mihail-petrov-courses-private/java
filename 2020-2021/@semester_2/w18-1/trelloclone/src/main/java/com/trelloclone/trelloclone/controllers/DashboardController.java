package com.trelloclone.trelloclone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

	@GetMapping("/dashboard")
	public String getDashboardPage() {
		return "main/dashboard";
	}
	
}
