package com.cafe24.cat24frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController 
{
	@RequestMapping("/list")
	public String list()
	{
		return "admin/admin";
	}
}
