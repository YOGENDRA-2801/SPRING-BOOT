package com.yoy.thymeleafbasic.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController 
{	
	@GetMapping("/profile")
	public String openProfile(Model model) {
		String name = "Yogendra Yadav" ;
		String greet = "Hope you have a nice day" ;
		model.addAttribute("name", name) ;
		model.addAttribute("greet", greet) ;
		return "profile" ;
	}
	
	@GetMapping("/about")
	public String openAbout(Model model) {
		int num1 = 57 ;
		int num2 = 82 ;
		model.addAttribute("num1", num1) ;
		model.addAttribute("num2", num2) ;
		return "about" ;
	}
	
	@GetMapping("/contact")
	public String openContact(Model model) {
		List<String> kontactList = List.of("9876543210", "1234567890", "6789012345", "5432167890") ;
		model.addAttribute("contacts", kontactList) ;
		return "contact" ;
	}
}
