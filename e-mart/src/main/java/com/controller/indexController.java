package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDao;
import com.model.Login;

@Controller
public class indexController {
	@Autowired
	UserDao userdao;

	@RequestMapping(path={"/"},method= {RequestMethod.GET,RequestMethod.POST})
	public String sayHello(Model model) {
	      return "index";
	   }
	
	@RequestMapping(value="/getLogin", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getLogin() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("lgn", new Login());
		modelAndView.setViewName("login");
		return modelAndView;
	}
}
