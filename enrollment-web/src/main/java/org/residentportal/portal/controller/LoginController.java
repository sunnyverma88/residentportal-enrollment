package org.residentportal.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login()
	{
		System.out.println("test ");
		
		return "login";
	}
	
	@RequestMapping("/login/success")
	public String loginSuccess()
	{
		return "index";
	}
	
	@RequestMapping(value="/login/failed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		//String errormessage = resources.getMessage("login.error", null, null);
		model.addAttribute("error", "true");
		return "login";
 
	}
	

	
}
