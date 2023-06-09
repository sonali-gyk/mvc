package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.demo.model.User;
import com.demo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService uservice;

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addinguser(@ModelAttribute User user,Model model)
	{
		User u=uservice.useradd(user);
		System.out.println("controller add");
		model.addAttribute("ac",user.getAcnumber());
		return "success";
	}
	@RequestMapping("/create")
	public String about()
	{
	
		return "account";
	}
	@RequestMapping(path = "/list")
	public String home(Model m) {

		List<User> list = uservice.getAll();
		m.addAttribute("userList", list);
		return "list";
	}

}
