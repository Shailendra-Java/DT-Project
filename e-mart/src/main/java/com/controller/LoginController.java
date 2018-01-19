package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Login;

@Controller
public class LoginController {

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String init(Model model) {
		
		model.addAttribute("msg", "Please enter your login details");
		return "Login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("Login") Login login) {
		
		if(login != null && login.getUserName() != null && login.getPassword() != null) {
			
			if(login.getUserName().equals("niit") && login.getPassword().equals("123")) {
				
				model.addAttribute("msg", "Welcome : "+login.getUserName());
				return "success";
			}
			else {
				
				model.addAttribute("error", "Invalid details");
				return "error";
			}
		}
		else {
			
			model.addAttribute("error", "Please enter details");
			return "Login";
		}
	}
}
