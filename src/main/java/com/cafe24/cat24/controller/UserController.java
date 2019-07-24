package com.cafe24.cat24.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@RequestMapping(value ="/hello", method = RequestMethod.GET )
	public String helloworld(Model model)
	{
		return "user/helloworld";
	}

}
