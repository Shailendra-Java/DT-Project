package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.backend.dao.UserDao;
import com.backend.model.User;
import com.model.Login;

@Controller
public class IndexController {
	
	@Autowired 
	UserDao userDaoImpl;
	
	@RequestMapping(value = {"/", "/index"}, method= {RequestMethod.POST,RequestMethod.GET})
	public String index() {
	      return "index";
	   }
	
	@RequestMapping(value="/goToRegister", method=RequestMethod.GET)
	public ModelAndView goToRegister()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new User());
		mv.setViewName("register");
		
		return mv;
		
	}
	
	@RequestMapping(value="/saveRegister", method=RequestMethod.POST)
	public ModelAndView saveRegister(@ModelAttribute("user")User user, BindingResult result)
	{
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) 
		{
			mv.setViewName("register");
		}
		else {
		user.setRole("ROLE_USER"); 
		userDaoImpl.insertUser(user);
		mv.setViewName("index");
		}
		return mv;
	}
	
	@RequestMapping(value="/getLogin", method= RequestMethod.GET)
	public ModelAndView getLogin() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("lgn", new Login());
		modelAndView.setViewName("login");
		return modelAndView;
	}
}
