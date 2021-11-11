package com.trelloclone.trelloclone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {
	
	@GetMapping("/boards/{id}")
	public String getBoardPage(@PathVariable int id) {
		
		return "board/view";
	}
}
