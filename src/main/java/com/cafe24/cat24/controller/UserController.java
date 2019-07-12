package com.cafe24.cat24.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@RequestMapping("/hello")
	public String helloworld(Model model)
	{
		return "user/helloworld";
	}
}
