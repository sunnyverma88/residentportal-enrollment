package org.residentportal.portal.controller;

import org.residentportal.portal.entity.Contact;
import org.residentportal.portal.entity.User;
import org.residentportal.portal.service.ContactService;
import org.residentportal.portal.utility.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {
	
    @Autowired
	private ContactService cs;
    
    @Autowired
    private EmailSender es;
    
    
    @ModelAttribute
	public Contact construct()
	{
		return new Contact();
	}
    
    @RequestMapping("/contact")
	public String showContact()
	{
		return "contact";
	}
    
	@RequestMapping(value="/contact" , method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("contact")Contact contact,Model model)
	{   
		boolean response;
		try
		{
			cs.save(contact);
			es.sendEmail("shwetabh.gaurav@gmail.com","Techieonthenet Query    "+contact.getUserId(), contact.getEmail()+"\n"+contact.getQuery());
			model.addAttribute("message", "Thanks for submitting the query. We will try to respond you as soon as possible");
			response=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			model.addAttribute("message" , "Sytem encountered issue");
			response=false;
		}
		return "redirect:/contact?success="+response;
	}
}
