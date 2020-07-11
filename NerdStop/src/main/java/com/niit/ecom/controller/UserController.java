package com.niit.ecom.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecom.dao.UserDao;
import com.ecom.model.User;
import com.ecom.service.EmailService;


@Controller
public class UserController {
	
	@Autowired
	private UserDao user_Dao;
	
	@Autowired
	EmailService service;
	

	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, BindingResult result)
	{
		
		/*if(result.hasErrors())
		{
			
			return "register";
		}*/
	
		if(user.getUserId()==0)
		{
			
		if(user_Dao.addUser(user))
		{  
		
			service.createdEmployeeMessage(user, "Hello!!!!!!!!!!!!!");
			
				return "redirect:/register?u=su";
		}
			else
				return null;
		}
		else
		{
			user_Dao.updateUser(user);
			return "user";
		}
	}
	
	
	@RequestMapping(value="/deleteUser/{userId}", method=RequestMethod.GET)
	public String deleteUser(@PathVariable("userId") int userId)
	{

		if(user_Dao.deleteUser(userId))
			return "redirect:/userHome";
		else
	     return null;
	}
	
	

	@RequestMapping(value="/updateUser/{userId}", method=RequestMethod.GET)
	public String updateUser(@PathVariable("userId")int userId, Model model)
	{
		
		model.addAttribute("user",user_Dao.getUserById(userId));
		model.addAttribute("userList",user_Dao.getAllUser());
		return "user";
	}

}
