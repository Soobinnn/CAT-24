package com.cafe24.cat24frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class userController 
{
	/** 로그인 **/
	@RequestMapping("/login")
	public String login(Model model)
	{
		return "user/login";
	}
}
