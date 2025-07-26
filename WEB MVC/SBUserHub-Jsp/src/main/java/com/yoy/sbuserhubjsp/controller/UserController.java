package com.yoy.sbuserhubjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yoy.sbuserhubjsp.entity.User;
import com.yoy.sbuserhubjsp.service.UserService;

@Controller
public class UserController {
	
	private final UserService usrSrv ;
	
	public UserController(UserService usrSrv) {
		super();
		this.usrSrv = usrSrv;
	}
	
	@GetMapping({"/", "/home"})
	public String home() {
		return "index" ;
	}

	@GetMapping("/register")
	public String register() {
		return "register" ;
	}
	
	@GetMapping("/login")
	public String login() {
		return "login" ;
	}
	
	@PostMapping("/reg-prof")
	public String profile(@ModelAttribute User user, Model model) {
		boolean status = usrSrv.addUser(user) ;
		if (status) {
			model.addAttribute("status", "Success") ;
			return "profile" ;
		}
		else {
			model.addAttribute("status", "Failed") ;
			model.addAttribute("msg", "Registration failed due to some error") ;
			return "register" ;
		}		
	}
	
	@PostMapping("/log-prof")
	public String openProfile(@ModelAttribute User authUser, Model model) {
		User validateUser = usrSrv.findById(authUser.getId()) ;
		if ( validateUser != null 
				&& validateUser.getPassword().equals(authUser.getPassword())) 
		{
			model.addAttribute("status", "Success") ;
			model.addAttribute("user", validateUser) ;
			return "profile" ;
		}
		else 
		{
			model.addAttribute("status", "Failed") ;
			model.addAttribute("msg", "Incorrect Username or Password") ;
			return "login" ;
		}		
	}
}