package com.trelloclone.trelloclone.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestWorkspaceController {

	@GetMapping("/restgetindex")
	public String getIndexPage() {
		return "index.html";
	}
}
