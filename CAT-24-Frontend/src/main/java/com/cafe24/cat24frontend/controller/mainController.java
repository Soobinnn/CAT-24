package com.cafe24.cat24frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController 
{
	@RequestMapping("/")
	public String main(Model model)
	{
		return "main/index";
	}
}
