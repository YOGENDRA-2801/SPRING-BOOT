package com.yoy.sbuserhubthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yoy.sbuserhubthymeleaf.entity.Client;
import com.yoy.sbuserhubthymeleaf.service.ClientService;

@Controller
public class ClientController {
	
	private final ClientService clientService ;
	
	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@GetMapping("/register")
	public String openRegPage( Model model) {
		model.addAttribute("client", new Client()) ;
		return "register" ;
	}
	
	@GetMapping("/login")
	public String openLoginPage( Model model) {
		model.addAttribute("client", new Client()) ;
		return "login" ;
	}
	
	@PostMapping("/regtr-prof")
	public String reg2pro(@ModelAttribute Client authclient, Model model) {
		Client newClient = clientService.addClient(authclient) ;
		if (newClient != null) {
			model.addAttribute("client", newClient) ;
			return "profile" ;
		}
		else {
			model.addAttribute("msg", "Registration failed please try again") ;
			return "register" ;
		}		
	}
	
	@PostMapping("/login-prof")
	public String login2pro(@ModelAttribute Client authclient, Model model) {
		Client validClient = clientService.findById(authclient.getId()) ;
		if (
				validClient != null && authclient.getPassword().equals(validClient.getPassword()) 
			) {
			model.addAttribute("client", validClient) ;
			return "profile" ;
		}
		else {
			model.addAttribute("msg", "Incorrect User-Id or Password please try again") ;
			return "login" ;
		}
	}
	
}
