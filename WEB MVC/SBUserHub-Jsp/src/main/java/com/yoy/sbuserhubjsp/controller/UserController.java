package com.yoy.sbuserhubjsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yoy.sbuserhubjsp.entity.User;

@Controller
public class UserController {
	
	private User user ;
	@Autowired
	public UserController(User user) {
		super();
		this.user = user;
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", user) ;
		return "register" ;
	}
	
	@PostMapping("/profile")
	public String profile(@ModelAttribute User user) {
		return "profile" ;
	}
}
