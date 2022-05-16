package com.trelloclone.trelloclone.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.trelloclone.trelloclone.models.users.User;
import com.trelloclone.trelloclone.repositories.users.UserRepository;

@Controller
public class UserProcessController {
	
	private String temporalMessage = null;
	
	@Autowired
	private UserRepository userRepository; 

	@GetMapping("/signup")
	public String getSignupPage(Model model) {
		
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@GetMapping("/signin")
	public String getSigninPage(Model model) {
		
		model.addAttribute("user", new User());
		return "signin";
	}
	
	@PostMapping("/authentication")
	public RedirectView processAuthentication(@ModelAttribute User entity, RedirectAttributes model) {
		
		Optional<User> dbUser =  this.userRepository.findUserByEmailAndPassword(entity.getEmail(), entity.getPassword());
		
		if(dbUser.isEmpty()) {

			model.addFlashAttribute("error", "Sammple error");
			return new RedirectView("/signin");
		}
		
		return new RedirectView("/dashboard");
	}
	
	@PostMapping("/authorization")
	public RedirectView processAuthorization(@ModelAttribute User entity) {
		
		this.userRepository.save(entity);
		return new RedirectView("/signin");
	}
}
